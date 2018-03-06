package sdz.kernel;

/**
 * 
 */
/**
 * @author pc
 *
 */
public class Eleve {
	Integer id;
	String prenom;
	String nom;
	Boolean sexe;
	Integer age;
	Classe classe;
	/**
	 * @param id
	 * @param prenom
	 * @param nom
	 * @param sexe
	 * @param age
	 */
	public Eleve(Integer id, String prenom, String nom, Boolean sexe,
			Integer age) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	/**
	 * @return
	 */
	public String getPrenom() {
		// TODO Auto-generated method stub
		return this.prenom;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.prenom + " " + this.nom;
	}
	/**
	 * @return
	 */
	public String getSexe() {
		// TODO Auto-generated method stub

		if (this.sexe) {
			return "M";

		} else {
			return "F";
		}

	}
	/**
	 * @return
	 */
	public String getAge() {
		// TODO Auto-generated method stub
		return (this.age).toString();
	}
	/**
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * @return
	 */
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	/**
	 * @return
	 */
	public Object getID() {
		return this.id;
	}
	/**
	 * 
	 */
	public void setNom(String nom) {
		this.nom = nom;
		
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
