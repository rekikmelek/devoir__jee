package web;

import java.util.List;

public interface IAutorisationDAO {
	
	public Autorisation saveenn(Autorisation aut);
	public List<Autorisation> autorisationParMC(String autme);
	public Autorisation getAutorisation(Long id);
	public Autorisation updateAutorisation(Autorisation aut);
	boolean deleteAutorisation(Long id);
	public List<Autorisation> getAutorisationsParEnseignantId(Long idEnseignant) ;

	
}
