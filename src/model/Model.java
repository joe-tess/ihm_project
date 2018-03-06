package sdz.model;

import sdz.kernel.Classe;
import sdz.kernel.Ecole;
import sdz.kernel.Eleve;

public class Model {

	private Ecole ecole;

	public Model() {

		Classe c1 = new Classe("CP1", "M. Lopez");
		Classe c2 = new Classe("CE1", "M. Da Silva");
		Classe c3 = new Classe("CE2", "Mme Rodriguez");
		Classe c4 = new Classe("CM2", "Mme Harcore");

		Eleve e1 = new Eleve(1, "Belmondo", "JP", true, 22);
		Eleve e2 = new Eleve(2, "Vacances", "Jojo", true, 23);
		Eleve e3 = new Eleve(3, "Boyle", "Susan", true, 24);
		Eleve e4 = new Eleve(4, "Biker", "Charlitoz", true, 13);
		Eleve e5 = new Eleve(5, "Michel", "Brad", true, 12);
		Eleve e6 = new Eleve(6, "Jouannette", "Pierce", true, 11);
		Eleve e7 = new Eleve(7, "Sousou", "Clarance", false, 10);
		Eleve e8 = new Eleve(8, "Ousontlesparents", "Chaipa", false, 9);
		Eleve e9 = new Eleve(9, "Leperse", "Julien", true, 8);
		Eleve e10 = new Eleve(10, "Boule", "Jean", true, 7);
		Eleve e11 = new Eleve(11, "Feuille", "Julie", false, 6);
		Eleve e12 = new Eleve(12, "Buisness", "Anniz", false, 5);
		Eleve e13 = new Eleve(13, "Stone", "Lucie", false, 4);
		Eleve e14 = new Eleve(14, "Starling", "Rose", false, 3);
		Eleve e15 = new Eleve(15, "Coliflowers", "Brenda", false, 2);
		Eleve e16 = new Eleve(16, "Dry", "Canada", false, 8);
		Eleve e17 = new Eleve(17, "Leperse", "Sophia", true, 68);
		Eleve e18 = new Eleve(18, "Seul", "Remi", true, 1);

		c1.addEleve(e1);
		c1.addEleve(e2);
		c1.addEleve(e3);
		c1.addEleve(e10);
		c1.addEleve(e11);
		c1.addEleve(e12);
		c1.addEleve(e13);

		c2.addEleve(e4);
		c2.addEleve(e5);
		c2.addEleve(e6);
		c2.addEleve(e14);
		c2.addEleve(e15);

		c3.addEleve(e7);
		c3.addEleve(e8);
		c3.addEleve(e9);
		c3.addEleve(e16);
		c3.addEleve(e17);

		c4.addEleve(e18);

		this.ecole = new Ecole("Ecole Primaire V. Hugo");

		ecole.addClasse(c1);
		ecole.addClasse(c2);
		ecole.addClasse(c3);
		ecole.addClasse(c4);

	}

	/**
	 * @return
	 */
	public Ecole getEcole() {
		return this.ecole;
	}
	
	public void updateInfo(Object o, Object o1){
		if (!o.equals(o1)){
			System.out.println("differents");
		}
	}
}
