package web;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import web.SingletonConnection;

public class IAutorisationDaoImpl implements IAutorisationDAO {

	
	
	
	@Override
	public Autorisation saveenn(Autorisation aut) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Autorisation (Enseignant_id,Institut,Module,Matiere,Nb_heure,Date) VALUES(?,?,?,?,?,?)");
			ps.setLong  (1, aut.getID_Enseignant());
			ps.setString(2, aut.getInstitut());
			ps.setString(3, aut.getModule());
			ps.setString(4, aut.getMatiere());
			ps.setDouble(5, aut.getNb_heure());
			ps.setString(6, aut.getDate());
			ps.executeUpdate();
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_Enseignant) as MAX_ID FROM Enseignant");
			ResultSet rs =ps2.executeQuery();
            System.out.println("here : " + aut.getID_Enseignant());

			if (rs.next()) {
				aut.setEnseignant_id(rs.getLong("MAX_ID"));
	            System.out.println("Valeur de enseignant_id après récupération : " + aut.getID_Enseignant());

			}
			ps.close();
			ps2.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aut;
	}
	public List<Autorisation> getAutorisationsParEnseignantId(Long idEnseignant) {
	    List<Autorisation> autorisations = new ArrayList<>();
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Autorisation WHERE enseignant_id = ?");
	        ps.setLong(1, idEnseignant);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Autorisation autorisation = new Autorisation();
	            autorisation.setId(rs.getLong("id"));
	            autorisation.setEnseignant_id(rs.getLong("enseignant_id"));
	            autorisation.setInstitut(rs.getString("institut"));
	            autorisation.setModule(rs.getString("module"));
	            autorisation.setMatiere(rs.getString("matiere"));
	            autorisation.setNb_heure(rs.getDouble("nb_heure"));
	            autorisation.setDate(rs.getString("date"));
	            autorisations.add(autorisation);
	        }
	        ps.close();
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return autorisations;
	}

	public boolean deleteAutorisation(Long id) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM Autorisation WHERE id = ?");
	        ps.setLong(1, id);
	        int rowsAffected = ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}


	
	@Override

	public List<Autorisation> autorisationParMC(String autme) {
		List<Autorisation> prods2= new ArrayList<Autorisation>();
		      Connection conn=SingletonConnection.getConnection();
		      try {
		      PreparedStatement ps= conn.prepareStatement("SELECT * FROM Autorisation WHERE matiere LIKE ?");
		ps.setString(1, "%"+autme+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Autorisation aut = new Autorisation();
		aut.setId(rs.getLong("id"));
		aut.setEnseignant_id(rs.getLong("enseignant_id"));
		aut.setInstitut(rs.getString("institut"));
		aut.setModule(rs.getString("module"));
		aut.setMatiere(rs.getString("matiere"));
		aut.setNb_heure(rs.getInt("nb_heure"));
		aut.setDate(rs.getString("date"));
		prods2.add(aut);
		}
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return prods2;

		}

	@Override
	public Autorisation getAutorisation(Long id) {
	    Connection conn = SingletonConnection.getConnection();
	    Autorisation autorisation = null;
	    try {
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Autorisation WHERE id = ?");
	        ps.setLong(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            autorisation = new Autorisation();
	            autorisation.setId(rs.getLong("id"));
	            autorisation.setEnseignant_id(rs.getLong("enseignant_id"));
	            autorisation.setInstitut(rs.getString("institut"));
	            autorisation.setModule(rs.getString("module"));
	            autorisation.setMatiere(rs.getString("matiere"));
	            autorisation.setNb_heure(rs.getDouble("nb_heure"));
	            autorisation.setDate(rs.getString("date"));
	        }
	        ps.close();
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return autorisation;
	}


	@Override
	public Autorisation updateAutorisation(Autorisation aut) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("UPDATE Autorisation SET Institut = ?, Module = ?, Matiere = ?, Nb_heure = ?, Date = ? WHERE id = ?");
	        ps.setString(1, aut.getInstitut());
	        ps.setString(2, aut.getModule());
	        ps.setString(3, aut.getMatiere());
	        ps.setDouble(4, aut.getNb_heure());
	        ps.setString(5, aut.getDate());
	        ps.setLong(6, aut.getId());
           // System.out.println("Ligne 152: " +aut.getID_Enseignant());

	        int rowsAffected = ps.executeUpdate();
	        //if (rowsAffected > 0) {
	        	Long enseignant_id = aut.getID_Enseignant();
	            System.out.println(enseignant_id);
	            System.out.println("Autorisation ID: " + aut.getId());
	            double nbHeure = aut.getNb_heure();
	            PreparedStatement psHeur = conn.prepareStatement("UPDATE enseignant SET heur = heur + ? WHERE id_enseignant = ?");
	            psHeur.setDouble(1, nbHeure);
	            System.out.println("Contenu de nbHeure : " + nbHeure);
	            psHeur.setLong(2, enseignant_id);
	            psHeur.executeUpdate();
	            return aut;
	      //  }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; 
	}


	

}
