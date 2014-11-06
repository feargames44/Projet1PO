import java.util.ArrayList;


public class Equipe {
	private String nom;
	private ArrayList<Coureur> coureurs;
	
	/**
	 * @param nom
	 * @param coureurs
	 */
	public Equipe(String nom, ArrayList<Coureur> coureurs) {
		this.nom = nom;
		this.coureurs = coureurs;
	}
	
	/**
	 * @param nom
	 */
	public Equipe(String nom) {
		this.nom = nom;
		this.coureurs = new ArrayList<Coureur>();
	}
	
	public void inserer(Coureur co){
		if(!this.coureurs.contains(co)){
			this.coureurs.add(co);
		}
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	public int getNbCoureurs(){
		return this.coureurs.size();
	}
	
	public Coureur getCoureur(int i){
		return this.coureurs.get(i);
	}
	
	public ArrayList<Coureur> getCoureurs(){
		return this.coureurs;
	}
	
	public Coureur getCoureurByDossard(int dossard){
		for(Coureur c : coureurs){
			if(c.getDossard() == dossard){
				return c;
			}
		}
		return null;
	}
	
	public int ageTotal(int annee){
		int agetotal = 0;
		for(Coureur co : this.coureurs){
			agetotal += co.age(annee);
		}
		return agetotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", coureurs=" + coureurs + "]" + "\n";
	}
	
	
}
