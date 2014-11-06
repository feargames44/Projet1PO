
public class Classement {
	
	private Etape etape;
	private int rang;
	private Coureur coureur;
	private Duree temps;
	
	/**
	 * @param etape
	 * @param rang
	 * @param coureur
	 * @param temps
	 */
	public Classement(Etape etape, int rang, Coureur coureur, Duree temps) {
		this.etape = etape;
		this.rang = rang;
		this.coureur = coureur;
		this.temps = temps;
	}

	/**
	 * @return the etape
	 */
	public Etape getEtape() {
		return etape;
	}

	/**
	 * @param etape the etape to set
	 */
	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	/**
	 * @return the rang
	 */
	public int getRang() {
		return rang;
	}

	/**
	 * @param rang the rang to set
	 */
	public void setRang(int rang) {
		this.rang = rang;
	}

	/**
	 * @return the coureur
	 */
	public Coureur getCoureur() {
		return coureur;
	}

	/**
	 * @param coureur the coureur to set
	 */
	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}

	/**
	 * @return the temps
	 */
	public Duree getTemps() {
		return temps;
	}

	/**
	 * @param temps the temps to set
	 */
	public void setTemps(Duree temps) {
		this.temps = temps;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classement [etape=" + etape + ", rang=" + rang + ", coureur="
				+ coureur + ", temps=" + temps + "]";
	}
	
	
	
}
