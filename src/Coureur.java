
public class Coureur {

	private String nom;
	private String prenom;
	private String nationalite;
	private int annee_naissance;
	private int dossard;

	/**
	 * @param nom
	 * @param prenom
	 * @param nationalite
	 * @param annee_naissance
	 * @param dossard
	 */
	public Coureur(String nom, String prenom, String nationalite, int annee_naissance, int dossard) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.annee_naissance = annee_naissance;
		this.dossard = dossard;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the nationalite
	 */
	public String getNationalite() {
		return nationalite;
	}
	/**
	 * @param nationalite the nationalite to set
	 */
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	/**
	 * @return the annee_naissance
	 */
	public int getAnnee_naissance() {
		return annee_naissance;
	}
	/**
	 * @param annee_naissance the annee_naissance to set
	 */
	public void setAnnee_naissance(int annee_naissance) {
		this.annee_naissance = annee_naissance;
	}
	/**
	 * @return the dossard
	 */
	public int getDossard() {
		return dossard;
	}
	/**
	 * @param dossard the dossard to set
	 */
	public void setDossard(int dossard) {
		this.dossard = dossard;
	}
	
	public int age(int annee){
		return (annee - this.annee_naissance);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coureur [nom=" + nom + ", prenom=" + prenom + ", nationalite="
				+ nationalite + ", annee_naissance=" + annee_naissance
				+ ", dossard=" + dossard + "]";
	}
	
	
	
}
