package sdz.kernel;

import java.util.ArrayList;

/**
 * 
 */
/**
 * @author pc
 *
 */
public class Classe {
	private ArrayList<Eleve> effectif;
	private String niveau;
	private String prof;

	/**
	 * @param niveau
	 * @param prof
	 */
	public Classe(String niveau, String prof) {

		this.niveau = niveau;
		this.prof = prof;
		this.effectif = new ArrayList<Eleve>();
	}

	public void addEleve(Eleve e) {
		this.effectif.add(e);
		e.setClasse(this);
	}

	/**
	 * @return
	 */
	public Object getNiveau() {
		return this.niveau;
	}

	public ArrayList<Eleve> getEleves() {
		return this.effectif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.niveau;
	}

	/**
	 * @return
	 */
	public int getNombreEleves() {
		return this.effectif.size();
	}

	public String getProf() {
		return this.prof;
	}

	public boolean contains(Eleve eleve) {
		return this.effectif.contains(eleve);
	}

	/**
	 * @param convertRowIndexToModel
	 * @return
	 */
	public Eleve get(int index) {

		return effectif.get(index);
	}

	/**
	 * @param prof
	 *            the prof to set
	 */
	public void setProf(String prof) {
		this.prof = prof;
	}

	/**
	 * 
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;

	}

}
