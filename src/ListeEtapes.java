import java.util.ArrayList;


public class ListeEtapes {
	private ArrayList<Etape> etapes;

	public ListeEtapes() {
		this.etapes = new ArrayList<Etape>();
	}
	
	public void inserer(Etape et){
		if(!this.etapes.contains(et)){
			this.etapes.add(et);
		}
	}

	/**
	 * @return the etapes
	 */
	public ArrayList<Etape> getEtapes() {
		return etapes;
	}

	/**
	 * @param etapes the etapes to set
	 */
	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListeEtapes [etapes=" + etapes + "]";
	}

	public Etape getEtape(int numero) {
		for(Etape et : this.etapes){
			if ((et.getNumero() == numero)){return et;}
		}
		return null;
	}
	


	public double getDistanceTotale() {
		double distTot = 0;
		for(Etape et : this.etapes){
			distTot += et.getDistance();
		}
		return distTot;
	}

	private double getNbEtapes() {
		return this.etapes.size();
	}
	
	public double getDistanceMoyenne() {
		double distMoy = this.getDistanceTotale()/this.getNbEtapes();
		return distMoy;
	}
	
	public Etape getMin(){
		Etape min = this.etapes.get(0);
		for(Etape et : this.etapes){
			if(min.getDistance() < et.getDistance()){
				min = et;
			}
		}
		return min;
	}
	
	public Etape getMax(){
		Etape max = this.etapes.get(0);
		for(Etape et : this.etapes){
			if(max.getDistance() > et.getDistance()){
				max = et;
			}
		}
		return max;
	}
	
	public Etape getEtapeByDepart(String depart){
		for(Etape et : this.etapes){
			if(et.getDepart().equals(depart)){
				return et;
			}
		}
		return null;
	}
	
	public Etape getEtapeByDate(String date){
		for(Etape et : this.etapes){
			if ((et.getDate().equals(date))){return et;}
		}
		return null;
	}

	public Etape getEtapeByArrivee(String arrivee){
		for(Etape et : this.etapes){
			if ((et.getArrivee().equals(arrivee))){return et;}
		}
		return null;
	}

}
