package projetuml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import utilitaire.DataExtractor;

public class Main {

	public static void main(String[] args) {		
		/*Date today = new Date();

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
		}*/

		DataExtractor test = new DataExtractor();
		Rallye superBesse = new Rallye("Super Besse", "Lima", "Perou");
		Edition superBesse1 = new Edition(superBesse, new Date(), new Date(1,1,2019));
		try {
			test.extract(superBesse1, "./data/SuperBesse.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int j=1;
		for(Etape et : superBesse1.getEtapes()){
			int i = 1;
			System.out.println("Etape " + j);
			for(Participant part : et.getClassement()) {
				System.out.print(i + " - ");
				System.out.println(part + " : " + et.getCourirTempsCorriges().get(part));
				i++;
			}
			j++;
		}
	}
}