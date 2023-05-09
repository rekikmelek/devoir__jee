package web;

import java.util.ArrayList;
import java.util.List;
import web.Autorisation;


public class IAutorisationModele {
	private String motCle2;
	List<Autorisation> Autorisations = new ArrayList<>();
	
	
	public String getMotCle2() {
		return motCle2;
	}
	public void setMotCle2(String motCle2) {
		this.motCle2 = motCle2;
	}
	public List<Autorisation> getAutorisations() {
		return Autorisations;
	}
	public void setAutorisations(List<Autorisation> Autorisations) {
		this.Autorisations = Autorisations;
	}

}
