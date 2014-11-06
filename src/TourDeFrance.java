import java.text.DecimalFormat;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;

/**
 * Classe applicative pour traiter les résultats du Tour de France 2014.
 *
 * Le code donné ici permet de lire le fichier des équipes (tdf14_equipe.txt)
 * ligne par ligne au moyen d'un objet issu de la classe LecteurFichier.
 * 
 * La classe est implémentée partiellement (rechercher les tags TODO).
 */
public class TourDeFrance {
	/**
	 * Fonction de création d'un coureur issu du fichier des équipes.
	 * @param ligne Une ligne du fichier des équipes concernant un coureur.
	 * @param leq   La liste des équipes en cours de création qui est modifiée
	 *              en ajoutant le coureur décrit sur la ligne.
	 */
	public static void traiterLigneEquipe(String ligne, ListeEquipe leq) {
		// La méthode split utilisée ci-dessous permet de décomposer une chaîne
		// en sous-chaînes séparées par une tabulation (caractère \t). Les
		// sous-chaînes sont récupérées dans un tableau elem.
		String[] elem = ligne.split("\t");

		// Données concernant le coureur
		String nat = elem[0];
		String nomCoureur = elem[1];
		String prenom = elem[2];
		int annee = Integer.parseInt(elem[3]);
		int dossard = Integer.parseInt(elem[4]);
		String nomEquipe = elem[5];

		// TODO Recherche de l'équipe dans la liste (via son nom)
		Equipe e = leq.getEquipeByNom(nomEquipe);
		// TODO Création éventuelle d'une équipe
		if(e == null){
			e = new Equipe(nomEquipe);
			leq.inserer(e);
		}
		// TODO Création du coureur et insertion dans l'équipe
		Coureur co = new Coureur(nomCoureur, prenom, nat, annee, dossard);
		e.inserer(co);
		leq.inserer(e);
	}
	
	/**
	 * Fonction de création d'une etape issu du fichier des etapes.
	 * @param ligne Une ligne du fichier des etapes.
	 * @param let   La liste des etapes en cours de création.
	 */
	public static void traiterLigneEtape(String ligne, ListeEtapes let) {
		String[] elem = ligne.split("\t");
		//Données concernant l'étape
		int numero = Integer.parseInt(elem[0]);
		String date = elem[1];
		String depart = elem[2];
		String arrivee = elem[3];
		double distance = Double.parseDouble(elem[4]);
		
		//Recherche de l'étape dans la liste (via son numero)
		Etape e = let.getEtape(numero);
		// Création éventuelle d'une étape
		if(e == null){
			e = new Etape(numero, date, depart, arrivee, distance);
			let.inserer(e);
		}
	}
	
	/**
	 * Fonction de création d'un classement issu du fichier du classement.
	 * @param ligne Une ligne du fichier du classement.
	 * @param lcl   La liste des classement en cours de création.
	 * @param let   La liste des etapes en cours de création.
	 * @param leq   La liste des equipes en cours de création.
	 */
	public static void traiterLigneClassement(String ligne, ListeClassement lcl, ListeEtapes let, ListeEquipe leq) {
		String[] elem = ligne.split("\t");
		//Données concernant l'étape
		int numero = Integer.parseInt(elem[0]);
		int rang = Integer.parseInt(elem[1]);
		int dossard = Integer.parseInt(elem[2]);
		String[] time = elem[3].split(":");
		int heures = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int secondes = Integer.parseInt(time[2]);
		//Recherche de l'étape dans la liste (via son numero)
		Etape et = let.getEtape(numero);
		Coureur co = leq.getEquipeByDossard(dossard);
		Duree du = new Duree(heures, minutes, secondes);
		
		Classement cl = lcl.getClassement(numero, dossard);
		// Création éventuelle d'une étape
		if(cl == null){
			lcl.inserer(new Classement(et, rang, co, du));
		}	
	}

	/**
	 * Fonction de création des équipes.
	 * @param  nomFichier Le nom du fichier des équipes.
	 * @param  leq        La liste des équipes qui est vide en entrée.
	 * @return true en cas de succès et dans ce cas la liste des équipes a été
	 *         remplie avec tous les coureurs présents dans le fichier,
	 *         false en cas d'échec.
	 */
	public static boolean creerEquipes(String nomFichier, ListeEquipe leq) {
		// Objet permet de lire un fichier texte ligne par ligne
		LecteurFichier lecteur = new LecteurFichier();

		if (lecteur.ouvrir(nomFichier)) {
			// On mange la première ligne (ligne inutile)
			String ligne = lecteur.lireLigne();

			// Création de la liste des équipes
			while ((ligne = lecteur.lireLigne()) != null) {
				traiterLigneEquipe(ligne,leq);
			}
			lecteur.fermer();
			return true;	// fichier lu avec succès
		}
		else {
			return false;	// erreur d'ouverture
		}
	}
	
	/**
	 * Fonction de création des équipes.
	 * @param  nomFichier Le nom du fichier des équipes.
	 * @param  leq        La liste des équipes qui est vide en entrée.
	 * @return true en cas de succès et dans ce cas la liste des équipes a été
	 *         remplie avec tous les coureurs présents dans le fichier,
	 *         false en cas d'échec.
	 */
	public static boolean creerEtapes(String nomFichier, ListeEtapes let) {
		// Objet permet de lire un fichier texte ligne par ligne
		LecteurFichier lecteur = new LecteurFichier();

		if (lecteur.ouvrir(nomFichier)) {
			// On mange la première ligne (ligne inutile)
			String ligne = lecteur.lireLigne();

			// Création de la liste des équipes
			while ((ligne = lecteur.lireLigne()) != null) {
				traiterLigneEtape(ligne,let);
			}
			lecteur.fermer();
			return true;	// fichier lu avec succès
		}
		else {
			return false;	// erreur d'ouverture
		}
	}
	
	/**
	 * Fonction de création des équipes.
	 * @param  nomFichier Le nom du fichier des équipes.
	 * @param  lcl        La liste des classements qui est vide en entrée.
	 * @return true en cas de succès et dans ce cas la liste des équipes a été
	 *         remplie avec tous les coureurs présents dans le fichier,
	 *         false en cas d'échec.
	 */
	public static boolean creerClassement(String nomFichier, ListeClassement lcl, ListeEtapes let, ListeEquipe leq) {
		// Objet permet de lire un fichier texte ligne par ligne
		LecteurFichier lecteur = new LecteurFichier();

		if (lecteur.ouvrir(nomFichier)) {
			// On mange la première ligne (ligne inutile)
			String ligne = lecteur.lireLigne();

			// Création de la liste des équipes
			while ((ligne = lecteur.lireLigne()) != null) {
				traiterLigneClassement(ligne, lcl, let, leq);
			}
			lecteur.fermer();
			return true;	// fichier lu avec succès
		}
		else {
			return false;	// erreur d'ouverture
		}
	}
	
	public static void echanger(ArrayList<Coureur> coureurs, int i, int j){
		Coureur tmp = coureurs.get(i);
		coureurs.set(i, coureurs.get(j));
		coureurs.set(j, tmp);
	}
	
	/*Tri rapide reccursif*/
	public static void triRapide(ArrayList<Coureur> coureurs, ListeClassement lesClassements)
	{
		int longueur=coureurs.size();
		triRapide(coureurs,0,longueur-1, lesClassements);
	}
  
	/*Partition*/
	private static int partition(ArrayList<Coureur> coureurs,int deb,int fin, ListeClassement lesClassements)
	{
		int compt=deb;
		Coureur pivot=coureurs.get(deb);
      
		for(int i=deb+1;i<=fin;i++)
		{
			if (lesClassements.getTempsTotalCoureur(coureurs.get(i).getDossard()).estSuperieur(lesClassements.getTempsTotalCoureur(pivot.getDossard())))
			{
				compt++;
				echanger(coureurs,compt,i);
			}
		}
		echanger(coureurs,deb,compt);
		return(compt);
	}

	/*Tri Rapide*/
	private static void triRapide(ArrayList<Coureur> coureurs,int deb,int fin, ListeClassement lesClassements)
	{
		if(deb<fin)
		{
			int positionPivot=partition(coureurs,deb,fin, lesClassements);
			triRapide(coureurs,deb,positionPivot-1, lesClassements);
			triRapide(coureurs,positionPivot+1,fin, lesClassements);
		}
	}

	
	/*Classement général*/
	public static ArrayList<Coureur> getClassementGeneral(ListeEquipe lesEquipes, ListeClassement lesClassements){
		ArrayList<Coureur> classement = new ArrayList<Coureur>();
		for(Equipe e : lesEquipes.getEquipes()){
			for(Coureur c : e.getCoureurs()){
				classement.add(c);
			}
		}
		/*Classement replit mais pas trié*/
		triRapide(classement, lesClassements);
		return classement;
	}

	/**
	 * Fonction principale.
	 * @param args Arguments en ligne 
		// TODO Recherche de l'équipe dans la liste (via son nom)
		leq.getEquipe(nomEquipe);
		// TODO Création éventuelle d'une équipe
		Equipe eq = new Equipe(nomEquipe);
		// TODO Création du coureur et insertion dans l'équipe
		Coureur co = new Coureur(nomCoureur, prenom, nat, annee, dossard);
		eq.inserer(co);de commande (inutile ici).
	 */
	public static void main(String[] args) {
		final int anneeCourante = 2014;
		final String nomFichierEquipe = "tdf14_equipe.txt";
		final String nomFichierEtape = "tdf14_etape.txt";
		final String nomFichierClassement = "tdf14_classement.txt";

		// TODO Création de la liste des équipes (initialisée à la liste vide)
		ListeEquipe lesEquipes = new ListeEquipe();
		//Création de la liste des etapes (initialisée à la liste vide)
		ListeEtapes lesEtapes = new ListeEtapes();
		//Création de la liste des classements (initialisée à la liste vide)
		ListeClassement lesClassements = new ListeClassement();
		
		// Traitement du fichier des équipes
		boolean res = creerEquipes(nomFichierEquipe, lesEquipes);
		if (!res) {
			System.out.println("Erreur lors du traitement du fichier des équipes");
		}
		else {
			// TODO Suite du programme principal (affichage pour constater que le
			//      fichier a été lu correctement, calcul de l'âge moyen des
			//     u traitement du fichier des équipes coureurs, ...)
			DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(2);
			System.out.println("Age moyen de tous les coureurs : " + f.format(lesEquipes.getAgeMoyenCoureurs(anneeCourante)));
			//System.out.println(lesEquipes);
		}
		// Traitement du fichier des etapes
		boolean res2 = creerEtapes(nomFichierEtape, lesEtapes);
		if (!res2) {
			System.out.println("Erreur lors du traitement du fichier des etapes");
		}
		else {
			//Quelle est la distance totale parcourue lors du Tour ? La distance moyenne des  ́etapes ?
			DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(3);
			System.out.println("Distance totale des etapes : " + lesEtapes.getDistanceTotale());
			System.out.println("Distance moyenne des etapes : " + f.format(lesEtapes.getDistanceMoyenne()));
			//Quelle est l’ ́etape la plus longue ? La plus courte ?
			System.out.println("Etape la plus courte : " + lesEtapes.getMin());
			System.out.println("Etape la plus longue : " + lesEtapes.getMax());
		}
		// Traitement du fichier des classements
		boolean res3 = creerClassement(nomFichierClassement, lesClassements, lesEtapes, lesEquipes);
		if (!res2) {
			System.out.println("Erreur lors du traitement du fichier des etapes");
		}
		else {
			//Quelle est la distance totale parcourue lors du Tour ? La distance moyenne des  ́etapes ?
			DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(3);
			System.out.println("Vainqueur partant de Mulhouse : " + lesClassements.getCoureur(lesEtapes.getEtapeByDepart("Mulhouse").numero, 1));
			System.out.println("Vainqueur arrivant a Risoul : " + lesClassements.getCoureur(lesEtapes.getEtapeByArrivee("Risoul").numero, 1));
			System.out.println("Vainqueur du 14 juillet : " + lesClassements.getCoureur(lesEtapes.getEtapeByDate("14/07/14").numero, 1));
			System.out.println(lesClassements.getTempsTotalCoureur(41));
			System.out.println(getClassementGeneral(lesEquipes, lesClassements));
		}
	}
}
