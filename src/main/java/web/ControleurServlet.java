package web;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.jasper.tagplugins.jstl.core.Out;

import web.EnseignantDaoImpl;
import web.Enseignant;
import web.SingletonConnection;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 IEnseignantDao metier1;
	 IAutorisationDAO  metier2;
	 @Override
	public void init() throws ServletException {
		metier1 = new EnseignantDaoImpl();
		metier2 = new IAutorisationDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{	
			   Calendar cal = Calendar.getInstance();
			   int semaine = cal.get(Calendar.WEEK_OF_YEAR);
			   request.setAttribute("semaine", semaine);
			request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
	
		else if (path.equals("/chercherensgn.do"))
		{
			String motCle1=request.getParameter("motCle1");
			EnseignantModele model1= new EnseignantModele();
			model1.setMotCle1(motCle1);
			List<Enseignant> prods1 = metier1.enseignantsParMC(motCle1);
			model1.setEnseignants(prods1);
			request.setAttribute("model1", model1);
			request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		else if (path.equals("/autorisation.do"))
		{
			Long enseignant_id=Long.parseLong(request.getParameter("enseignant_id"));
			   String institut=request.getParameter("institut");
			   String module = request.getParameter("module");
			   String matiere=request.getParameter("matiere");
			   double nb_heure=  Double.parseDouble(request.getParameter("nb_heure"));
			   String date=request.getParameter("date");    
			   Autorisation A = metier2.saveenn(new Autorisation(enseignant_id,institut,module,matiere,nb_heure, date));
    		   request.setAttribute("Autorisation", A);
			   Enseignant enseignant = metier1.getEnseignant(enseignant_id);
			   double H= Double.parseDouble(request.getParameter("heurre"))  + Double.parseDouble(request.getParameter("nb_heure"));
 
			 request.setAttribute("enseignant", enseignant);     
			  
			Connection connection = null;
			       try {
			           connection = SingletonConnection.getConnection();
			           String updateQuery = "UPDATE enseignant SET heur = ? WHERE id_enseignant = ?";
			           PreparedStatement statement = connection.prepareStatement(updateQuery);
			           statement.setDouble(1, H);
			           statement.setLong(2, enseignant_id);
			           statement.executeUpdate();

			           request.getRequestDispatcher("confirmationautorisation.jsp").forward(request, response);
			       } catch (SQLException e) {
			           e.printStackTrace();
			       } finally {
			           try {
			               if (connection != null && !connection.isClosed()) {
			           System.out.println("success");
			               }
			           } catch (SQLException e) {
			               e.printStackTrace();
			           }
			       }
			request.getRequestDispatcher("autorisation.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisieProduit.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
			 String Nom=request.getParameter("Nom");
			    String Prenom=request.getParameter("Prenom");
			    double matricule = Double.parseDouble(request.getParameter("matricule"));
			    String Statut=request.getParameter("Statut");
			    double heur  = 0;

			    Enseignant E = metier1.saveen(new Enseignant(Nom,Prenom,matricule,Statut, matricule));
				request.setAttribute("Enseignant", E);
				request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
	
		else if (path.equals("/supprimerEnseignant.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier1.deleteEnseignant(id);
		    response.sendRedirect("chercherensgn.do?motCle1=");
		}
		
		else if (path.equals("/editerEnseignant.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
			request.getRequestDispatcher("editerEnseignat.jsp").forward(request,response);
		}
		else if (path.equals("/editerAutorisation.do")) {
		    Long id = Long.parseLong(request.getParameter("id"));
		    Autorisation autorisation = metier2.getAutorisation(id); 
	        System.out.println(autorisation);
		    if (autorisation != null) {
		        request.setAttribute("autorisation", autorisation);	     
		        request.getRequestDispatcher("editerAutorisation.jsp").forward(request, response);
		    } else {
		    	System.out.println("erreur edit");
		    }
		}
		else if (path.equals("/supprimerAutorisation.do")) {
			    Long id = Long.parseLong(request.getParameter("id"));
			    Autorisation autorisation = metier2.getAutorisation(id);

			    if (autorisation != null) {
			        Long enseignantId = autorisation.getID_Enseignant();
			        Enseignant enseignant = metier1.getEnseignant(enseignantId);
			        double nbHeureAutorisation = autorisation.getNb_heure();
			        double heurEnseignant = enseignant.getHeur() - nbHeureAutorisation;
			        enseignant.setHeur(heurEnseignant);
			        metier1.updateEnseignant(enseignant);

			        boolean suppressionReussie = metier2.deleteAutorisation(id);

			        if (suppressionReussie) {
			            response.sendRedirect("chercherensgn.do?motCle1=");
			        } else {
			            System.out.println("Erreur lors de la suppression");
			        }
			    }
			    response.sendRedirect("chercherensgn.do?motCle1=");

			}

		

		else if (path.equals("/voirAutorisation.do")) {
		    Long id = Long.parseLong(request.getParameter("id"));
		    Autorisation autorisation = metier2.getAutorisation(id); 
		    if (autorisation != null) {
		        request.setAttribute("autorisation", autorisation);     
		        request.getRequestDispatcher("voirAutorisation.jsp").forward(request, response);
		    } else {
		    	System.out.println("Error Voir Autorisation");
		    }
		}
		else if (path.equals("/voirEnseignant.do")) {
		    Long idEnseignant = Long.parseLong(request.getParameter("id"));
		    Enseignant enseignant = metier1.getEnseignant(idEnseignant);
		    List<Autorisation> autorisations = metier2.getAutorisationsParEnseignantId(idEnseignant);
		    request.setAttribute("enseignant", enseignant);
		    request.setAttribute("autorisations", autorisations);
		    System.out.println(autorisations);
		    request.getRequestDispatcher("voirEnseignant.jsp").forward(request, response);
		}

		else if (path.equals("/autEnse.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
		    System.out.println(en);
			request.getRequestDispatcher("autorisation.jsp").forward(request,response);
		}
		
		else if (path.equals("/recupens.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Enseignant en = metier1.getEnseignant(id);
		    request.setAttribute("enseignant", en);
		    System.out.println(en);
			request.getRequestDispatcher("confirmationautorisation.jsp").forward(request,response);
		}
	
		else if (path.equals("/updateEnseignant.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			 double matricule = Double.parseDouble(request.getParameter("matricule"));
			 String statut=request.getParameter("statut");
			 double heur = Double.parseDouble(request.getParameter("heur"));
			 Enseignant en = new Enseignant();
			 en.setId_enseignant(id);			
			 en.setNom(nom);
			 en.setPrenom(prenom);
			 en.setMatricule(matricule);
			 en.setStatut(statut);
			 en.setHeur(heur);
			 metier1.updateEnseignant(en);
			 request.setAttribute("enseignant", en);
				request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		else if (path.equals("/updateAutorisation.do")) {
		    Long id = Long.parseLong(request.getParameter("id"));
		    String institut = request.getParameter("institut");
		    String module = request.getParameter("module");
		    String matiere = request.getParameter("matiere");
		    double nb_heure = Double.parseDouble(request.getParameter("nb_heure"));
		    String date = request.getParameter("date");
		    Autorisation aut = new Autorisation();
		    aut.setId(id);
		    aut.setInstitut(institut);
		    aut.setModule(module);
		    aut.setMatiere(matiere);
		    aut.setNb_heure(nb_heure);
		    aut.setDate(date);
		    Autorisation updatedAutorisation = metier2.updateAutorisation(aut);
		    if (updatedAutorisation != null) {
		        request.setAttribute("autorisation", updatedAutorisation);
		        request.getRequestDispatcher("enseignant.jsp").forward(request, response);
		    } else {
		       System.out.println("Error lors d'update");
		    }
		}
		else if (path.equals("/updateEnse.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			 double matricule = Double.parseDouble(request.getParameter("matricule"));
			 String statut=request.getParameter("statut");
			 double heur = Double.parseDouble(request.getParameter("heur"));
			
			 Enseignant en = new Enseignant();
			 en.setId_enseignant(id);			
			 en.setNom(nom);
			 en.setPrenom(prenom);
			 en.setMatricule(matricule);
			 en.setStatut(statut);
			 en.setHeur(heur);

			// Retrieve the existing value of heur from the Enseignant object
			 //int existingHeur = getHeur();

			 // Add the new value of heur to the existing value
			// int updatedHeur = existingHeur + heur;

			 // Set the updated value of heur to the Enseignant object
			// en.setHeur(updatedHeur);

			 metier1.updateEnse(en);
			 request.setAttribute("enseignant", en);
			 String input = request.getParameter("heur");
			 
				request.getRequestDispatcher("enseignant.jsp").forward(request,response);
		}
		
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}