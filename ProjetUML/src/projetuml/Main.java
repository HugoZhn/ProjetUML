package projetuml;

import java.io.FileNotFoundException;
import java.util.*;

import utilitaire.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {		
		/*Date today = new Date();

		//Cr�er des coureurs
		Coureur HZ= new Coureur("Hugo", "Zahn", today);
		Coureur KH = new Coureur("Kam", "Hachmi", today);
		Coureur UB = new Coureur("Usain", "Bolt", today);

		//Cr�er les v�hicules
		Voiture v1 =new Voiture("YGHT56", 20);
		Voiture v2 =new Voiture("VBDH12", 18);
		Voiture v3 =new Voiture("TLKI74", 25);

		//Cr�er les rallyes
		Rallye rallyeCarda=new Rallye("Rallye des Cardabelles", "Villeneuve-Aveyron","France");

		//Cr�er les �ditions
		Date dateFin = new Date(31,10,2018);
		Edition editionCardabelles = new Edition(rallyeCarda, today, dateFin);

		//Cr�er les �tapes
		Etape etape1 = new Etape(editionCardabelles, 3200);

		//Cr�er les participants
		Participant p1=new Participant(v1, editionCardabelles, HZ);
		Participant p2=new Participant(v2, editionCardabelles, KH);
		Participant p3=new Participant(v3, editionCardabelles, UB);

		//On cherche le nom de l'�dition
		System.out.println("Cette �dition du " + editionCardabelles.getDateDebER() + " se nomme " + editionCardabelles.getEditionDe() );

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
		
		//Connexion
		Connexion conn = new Connexion();
		test.extractConn(conn, "./data/Connexion.csv");
	
		Iterator<String> itConn;
		HashMap<String, String> lsConn = conn.getConn();
		itConn = lsConn.keySet().iterator();
		while(itConn.hasNext()) {
			String em = itConn.next();
			System.out.println("Email : " +em+", Mot de pass : " +lsConn.get(em));
		}
		
		//Edition
		Rallye superBesse = new Rallye("Super Besse", "Lima", "Perou");
		Edition superBesse1 = new Edition(superBesse, new Date(), new Date(1,1,2019));
		test.extractEdition(superBesse1, "./data/SuperBesse.csv");
		
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