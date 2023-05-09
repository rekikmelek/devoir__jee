package web;
import java.io.Serializable;

public class Enseignant implements Serializable {
	private Long id_enseignant;
	private String Nom;
	private String Prenom;
	private double matricule;
	private String Statut;
	private double heur;
	public Enseignant() {
		super();
	}
	public Enseignant(String Nom, String prenom, double matricule, String statut,
			double heur) {
		super();
		this.Nom = Nom;
		this.Prenom = prenom;
		this.matricule = matricule;
		this.Statut = statut;
		this.heur = heur;
	}
	public Long getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(Long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public double getMatricule() {
		return matricule;
	}
	public void setMatricule(double matricule) {
		this.matricule = matricule;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	
	public double getHeur() {
		return heur;
	}
	public void setHeur(double heur) {
		this.heur = heur;
	}
	@Override
	public String toString() {
		return "Enseignant [id_enseignant=" + id_enseignant + ", Nom=" + Nom + ", Prenom=" + Prenom + ", matricule="
				+ matricule + ", Statut=" + Statut +  ", heur=" + heur + "]";
	}
	
}
