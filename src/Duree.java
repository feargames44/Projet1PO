
public class Duree {
	private int heures;
	private int minutes;
	private int secondes;
	/**
	 * @param heures
	 * @param minutes
	 * @param secondes
	 */
	public Duree(int heures, int minutes, int secondes) {
		this.heures = heures;
		this.minutes = minutes;
		this.secondes = secondes;
	}
	
	public Duree() {
		this.heures = 0;
		this.minutes = 0;
		this.secondes = 0;
	}
	
	/**
	 * @return the heures
	 */
	public int getHeures() {
		return heures;
	}
	/**
	 * @param heures the heures to set
	 */
	public void setHeures(int heures) {
		this.heures = heures;
	}
	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	/**
	 * @return the secondes
	 */
	public int getSecondes() {
		return secondes;
	}
	/**
	 * @param secondes the secondes to set
	 */
	public void setSecondes(int secondes) {
		this.secondes = secondes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Duree [heures=" + heures + ", minutes=" + minutes
				+ ", secondes=" + secondes + "]";
	}
	
	public Duree sommeDuree(Duree d){
		int sec = (this.secondes + d.secondes) % 60;
		int rsec = (this.secondes + d.secondes) / 60;
		int min = (this.minutes + d.minutes) % 60 + rsec;
		int rmin = (this.minutes + d.minutes) / 60;
		int hr = (this.heures + d.heures) + rmin;
		return new Duree(hr, min, sec);
	}
	
	public boolean estSuperieur(Duree d){
		int d_en_sec = d.heures * 3600 + d.minutes * 60 + d.secondes;
		int this_en_sec = this.heures * 3600 + this.minutes * 60 + this.secondes;
		return this_en_sec > d_en_sec;
	}
}
