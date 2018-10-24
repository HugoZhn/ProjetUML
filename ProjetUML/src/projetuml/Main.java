package projetuml;

public class Main {

	public static void main(String[] args) {		
		Date today = new Date();
		
		//Créer des coureurs
		Coureur HZ= new Coureur("Hugo", "Zahn", today);
		Coureur KH = new Coureur("Kam", "Hachmi", today);
		Coureur UB = new Coureur("Usain", "Bolt", today);
		
		//Créer les véhicules
		Voiture v1 =new Voiture("YGHT56", 20);
		Voiture v2 =new Voiture("VBDH12", 18);
		Voiture v3 =new Voiture("TLKI74", 25);
		
		//Créer les rallyes
		Rallye rallyeCarda=new Rallye("Rallye des Cardabelles", "Villeneuve-Aveyron","France");
		
		//Créer les éditions
		Date dateFin = new Date(31,10,2018);
		Edition editionCardabelles = new Edition(rallyeCarda, today, dateFin);
		
		//Créer les étapes
		Etape etape1 = new Etape(editionCardabelles, 3200);
		
		//Créer les participants
		Participant p1=new Participant(v1, editionCardabelles, HZ);
		Participant p2=new Participant(v2, editionCardabelles, KH);
		Participant p3=new Participant(v3, editionCardabelles, UB);
		
		//On cherche le nom de l'édition
		System.out.println("Cette édition du " + editionCardabelles.getDateDebER() + " se nomme " + editionCardabelles.getEditionDe() );
		
		System.out.println();
		
		etape1.affecterTemps(p1, 9.6);
		etape1.affecterTemps(p2, 18.6);
		etape1.affecterTemps(p3, 11.6);
		
		
		int i = 1;
		for(Participant part : editionCardabelles.getClassement()) {
			System.out.print(i + " - ");
			System.out.println(part + " : " + part.getTempsFinal());
			i++;
		}
	}

}