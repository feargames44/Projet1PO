import java.util.ArrayList;


public class ListeClassement {
private ArrayList<Classement> classements;
	
	public ListeClassement() {
		this.classements = new ArrayList<Classement>();
	}

	public void inserer(Classement cl){
		if(!this.classements.contains(cl)){
			this.classements.add(cl);
		}
	}

	public Classement getClassement(int num_etape, int dossard){
		for(Classement c : this.classements){
			if(c.getEtape().numero == num_etape && c.getCoureur().getDossard() == dossard){
				return c;
			}
		}
		return null;
	}
	
	public Coureur getCoureur(int num_etape, int rang){
		for(Classement c : this.classements){
			if(c.getEtape().numero == num_etape && c.getRang() == rang){
				return c.getCoureur();
			}
		}
		return null;
	}
	
	public Duree getTempsTotalCoureur(int dossard){
		Duree d = new Duree();
		for(Classement c : this.classements){
			if(c.getCoureur().getDossard() == dossard){
				d = d.sommeDuree(c.getTemps());
			}
		}
		return d;
	}
	

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListeClassement [classements=" + classements + "]";
	}
	
}
