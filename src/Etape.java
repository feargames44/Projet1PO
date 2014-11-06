
public class Etape {
	int numero;
	String date;
	String depart;
	String arrivee;
	double distance;
	/**
	 * @param numero
	 * @param date
	 * @param depart
	 * @param arrivee
	 * @param distance
	 */
	public Etape(int numero, String date, String depart, String arrivee,
			double distance) {
		this.numero = numero;
		this.date = date;
		this.depart = depart;
		this.arrivee = arrivee;
		this.distance = distance;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the depart
	 */
	public String getDepart() {
		return depart;
	}
	/**
	 * @param depart the depart to set
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}
	/**
	 * @return the arrivee
	 */
	public String getArrivee() {
		return arrivee;
	}
	/**
	 * @param arrivee the arrivee to set
	 */
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Etape [numero=" + numero + ", date=" + date + ", depart="
				+ depart + ", arrivee=" + arrivee + ", distance=" + distance
				+ "]";
	}
}
