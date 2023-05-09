package web;

import java.util.List;

public interface IEnseignantDao {
	public Enseignant saveen(Enseignant en);
	public List<Enseignant> enseignantsParMC(String me);
	public Enseignant getEnseignant(Long id);
	public Enseignant updateEnseignant(Enseignant en);
	public Enseignant updateEnse(Enseignant en);

	public void deleteEnseignant(Long id);
	//public boolean checkIfValidEnseignant(Long id);
	public List<Enseignant> getAll();
	public Enseignant getHeur(Enseignant en);
	



	

}
