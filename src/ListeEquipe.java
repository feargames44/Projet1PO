import java.text.DecimalFormat;
import java.util.ArrayList;


public class ListeEquipe {
	private ArrayList<Equipe> equipes;
	
	public ListeEquipe() {
		this.equipes = new ArrayList<Equipe>();
	}
	
	public void inserer(Equipe eq){
		if(!this.equipes.contains(eq)){
			this.equipes.add(eq);
		}
	}
	
	public Equipe getEquipeByNom(String nomEquipe){
		for(Equipe eq : this.equipes){
			if ((eq.getNom().equals(nomEquipe))){return eq;}
		}
		return null;
	}
	
	public int nbEquipes(){
		return this.equipes.size();
	}
	
	public Equipe getEquipe(int i){
		return this.equipes.get(i);
	}
	
	public ArrayList<Equipe> getEquipes(){
		return this.equipes;
	}
	
	public Coureur getEquipeByDossard(int dossard){
		for(Equipe e : equipes){
			if(e.getCoureurByDossard(dossard) != null){
				return e.getCoureurByDossard(dossard);
			}
		}
		return null;
	}
	
	public int getNbCoureurs(){
		int nbCoureurs = 0;
		for (Equipe e : equipes) {
			nbCoureurs += e.getNbCoureurs();
		}
		return nbCoureurs;
	}
	
	public double getAgeMoyenCoureurs(int annee){
		double ageTotale = 0.0;
		for(int i=0; i<this.nbEquipes();i++){
			ageTotale += this.getEquipe(i).ageTotal(annee);
		}			
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return ageTotale / this.getNbCoureurs();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListeEquipe [equipes=" + equipes + "]" + "\n";
	}	
		
}
