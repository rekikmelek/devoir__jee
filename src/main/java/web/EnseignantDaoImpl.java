package web;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import web.SingletonConnection;
import web.Enseignant;

public class EnseignantDaoImpl implements IEnseignantDao{
	

	@Override
	public Enseignant saveen(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Enseignant(Nom,Prenom,Matricule,Statut) VALUES(?,?,?,?)");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
			ps.setDouble(3, en.getMatricule());
			ps.setString(4, en.getStatut());



			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_Enseignant) as MAX_ID FROM Enseignant");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				en.setId_enseignant(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}

	@Override
	public List<Enseignant> enseignantsParMC(String me) {
		 List<Enseignant> prods1= new ArrayList<Enseignant>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
	    	   PreparedStatement ps= conn.prepareStatement("SELECT * FROM Enseignant WHERE Nom LIKE ?");
			ps.setString(1, "%"+me+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant en = new Enseignant();
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("nom"));
				en.setPrenom(rs.getString("prenom"));
				en.setMatricule(rs.getDouble("matricule"));
				en.setStatut(rs.getString("statut"));
				en.setHeur(rs.getDouble("heur"));
				prods1.add(en);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods1;
		
	}

	@Override
	public Enseignant getEnseignant(Long id) {
		 Connection conn=SingletonConnection.getConnection();
		 Enseignant en = new Enseignant();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from Enseignant where ID_Enseignant = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("nom"));
				en.setPrenom(rs.getString("prenom"));
				en.setMatricule(rs.getDouble("matricule"));
				en.setStatut(rs.getString("statut"));
				en.setHeur(rs.getDouble("heur"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return en;	}

	@Override
	public Enseignant updateEnseignant(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE Enseignant SET NOM=?,PRENOM=?,MATRICULE=?,STATUT=?,HEUR=? WHERE ID_Enseignant=?");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
			ps.setDouble(3, en.getMatricule());
			ps.setString(4, en.getStatut());
			ps.setDouble(5, en.getHeur());
			ps.setLong(6, en.getId_enseignant());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}


	@Override
	public Enseignant updateEnse(Enseignant en) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE Enseignant SET NOM=?,PRENOM=?,MATRICULE=?,STATUT=?,HEUR=? WHERE ID_Enseignant=?");
			ps.setString(1, en.getNom());
			ps.setString(2, en.getPrenom());
			ps.setDouble(3, en.getMatricule());
			ps.setString(4, en.getStatut());
			ps.setDouble(5, en.getHeur());
			ps.setLong(6, en.getId_enseignant());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return en;
	}

	@Override
	public Enseignant getHeur(Enseignant en) {
	    Connection conn = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = conn.prepareStatement("SELECT HEUR FROM Enseignant WHERE ID_Enseignant=?");
	        ps.setLong(1, en.getId_enseignant());

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            double heur = rs.getDouble("HEUR");
	            en.setHeur(heur);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return en;
	}

	@Override
	public void deleteEnseignant(Long id) {
	    Connection conn = SingletonConnection.getConnection();
	    try {

	    	PreparedStatement psDeleteAutorisations = conn.prepareStatement("DELETE FROM Autorisation WHERE enseignant_id = ?");
	        psDeleteAutorisations.setLong(1, id);
	        psDeleteAutorisations.executeUpdate();
	        psDeleteAutorisations.close();

	        PreparedStatement psDeleteEnseignant = conn.prepareStatement("DELETE FROM Enseignant WHERE id_enseignant = ?");
	        psDeleteEnseignant.setLong(1, id);
	        psDeleteEnseignant.executeUpdate();
	        psDeleteEnseignant.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Enseignant> getAll() {
		 List<Enseignant> prods1= new ArrayList<Enseignant>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
	    	   PreparedStatement ps= conn.prepareStatement("SELECT * FROM Enseignant ");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant en = new Enseignant();
				en.setId_enseignant(rs.getLong("id_enseignant"));
				en.setNom(rs.getString("Nom"));
				en.setPrenom(rs.getString("Prenom"));
				en.setMatricule(rs.getDouble("Matricule"));
				en.setStatut(rs.getString("Statut"));
				en.setHeur(rs.getDouble("Heur"));
				prods1.add(en);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods1;
	}


	
	

}
