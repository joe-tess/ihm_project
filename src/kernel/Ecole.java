package sdz.kernel;

import java.util.ArrayList;

/**
 * 
 */
/**
 * @author pc
 *
 */
public class Ecole {

	ArrayList<Classe> listeClasse;
	String nom;

	public Ecole(String nom) {
		listeClasse = new ArrayList<Classe>();
		this.nom = nom;
	}

	public void addClasse(Classe c) {
		listeClasse.add(c);
	}

	public ArrayList<Classe> getClasses() {
		return listeClasse;
	}

	public String getNom() {
		return this.nom;
	}
}
