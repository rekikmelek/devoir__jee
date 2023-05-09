package web;

import java.util.List;

import web.Enseignant;

public class TestDao {

	public static void main(String[] args) {
		
		
		EnseignantDaoImpl pdao1= new EnseignantDaoImpl();
		Enseignant prod1= pdao1.saveen(new Enseignant ("bbbb","melek",452,"professeur",15));
		System.out.println(prod1);
		List<Enseignant> prods1=pdao1.enseignantsParMC("rekik");
		for (Enseignant e : prods1)
		System.out.println(e);
		
		
		/*IAutorisationDaoImpl pdao2= new IAutorisationDaoImpl();
		Autorisation prod2= pdao2.saveenn(new Autorisation (1,1,"tt","hh","melek",452,"professeur"));
		System.out.println(prod2);
		List<Autorisation> prods2=pdao2.autorisationParMC("1");
		for (Autorisation e : prods2)
		System.out.println(e);*/
		
		
	}

}