package web;

import java.util.ArrayList;
import java.util.List;
import web.Enseignant;

public class EnseignantModele {
	private String motCle1;
	List<Enseignant> Enseignants = new ArrayList<>();
	
	
	public String getMotCle1() {
		return motCle1;
	}
	public void setMotCle1(String motCle1) {
		this.motCle1 = motCle1;
	}
	public List<Enseignant> getEnseignants() {
		return Enseignants;
	}
	public void setEnseignants(List<Enseignant> Enseignants) {
		this.Enseignants = Enseignants;
	}

}
