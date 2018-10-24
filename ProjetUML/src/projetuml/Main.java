package projetuml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import utilitaire.DataExtractor;
import utilitaire.Date;
import utilitaire.TimeParser;

public class Main {

	public static void main(String[] args) {	
		
		// Rallye Super Bresse et Val Thorens donn�s
		DataExtractor deX = new DataExtractor();
		Rallye superBesse = new Rallye("Super Besse", "Lima", "Perou");
		Edition superBesse1 = new Edition(superBesse, new Date(1,1,2017), new Date(16,8, 2017));
		
		System.out.println(superBesse1);
		
		try {
			deX.extract(superBesse1, "./data/SuperBesse.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int j=1;
		for(Etape et : superBesse1.getEtapes()){
			int i = 1;
			System.out.println("Etape " + j);
			for(Participant part : et.getClassement()) {
				System.out.print(i + " - ");
				TimeParser chrono = new TimeParser(et.getCourirTempsCorriges().get(part));
				System.out.println(part + " : " + chrono);
				i++;
			}
			System.out.println("\n");
			j++;
		}
		
		System.out.println("Classement d�finitif : \n");
		int i = 1;
		for(Participant part: superBesse1.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(part.getTempsFinal());
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		System.out.println("\n _________________________________ \n");
		
		Rallye valThorens = new Rallye("Val Thorens", "Val Thorens ", "France");
		Edition valThorens1 = new Edition(valThorens, new Date(16,8,2017), new Date(12,12,2017));

		System.out.println(valThorens1);
		
		try {
			deX.extract(valThorens1, "./data/ValThorens.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		j=1;
		for(Etape et : valThorens1.getEtapes()){
			int h = 1;
			System.out.println("Etape " + j);
			for(Participant part : et.getClassement()) {
				System.out.print(h + " - ");
				TimeParser chrono = new TimeParser(et.getCourirTempsCorriges().get(part));
				System.out.println(part + " : " + chrono);
				h++;
			}
			System.out.println("\n");
			j++;
		}
		
		System.out.println("Classement d�finitif : \n");
		i = 1;
		for(Participant part: valThorens1.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(part.getTempsFinal());
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		System.out.println("\n _________________________________ \n");
		
		System.out.println("Test classements interm�diaires");
		
		Date today = new Date();

		//Cr�er des coureurs
		Coureur HZ= new Coureur("Hugo", "Zahn", today);
		Coureur KH = new Coureur("Kam", "Hachmi", today);
		Coureur UB = new Coureur("Usain", "Bolt", today);

		//Cr�er les v�hicules
		Voiture v1 =new Voiture("YGHT56", "Renault Clio", 200);
		Voiture v2 =new Voiture("VBDH12", "Renault Twingo", 180);
		Voiture v3 =new Voiture("TLKI74", "Peugeot 106", 220);

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

		etape1.affecterTemps(p1, 96);
		etape1.affecterTemps(p2, 186);
		
		System.out.println("Classement provisoire �tape :");
		i = 1;
		for(Participant part: etape1.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(etape1.getCourirTempsCorriges().get(part));
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		etape1.affecterTemps(p3, 106);
		
		System.out.println("\nClassement �tape :");	
		i = 1;
		for(Participant part: etape1.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(etape1.getCourirTempsCorriges().get(part));
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		System.out.println("\nClassement g�n�ral provisoire :");	
		i = 1;
		for(Participant part: editionCardabelles.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(part.getTempsFinal());
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		Etape etape2 = new Etape(editionCardabelles, 5900);
		
		etape2.affecterTemps(p1, 180);
		etape2.affecterTemps(p2,200);
		etape2.affecterTemps(p3, 166);
		
		System.out.println("\nClassement g�n�ral :");	
		i = 1;
		for(Participant part: editionCardabelles.getClassement()){
			System.out.print(i + " - ");
			TimeParser chrono = new TimeParser(part.getTempsFinal());
			System.out.println(part + " : " + chrono);
			i++;
		}
		
		Paris premierparis = new Paris(10, HZ, editionCardabelles) ;
		
		editionCardabelles.validerClassement();
		
		System.out.println("\nSuite � votre pari  concernant " + HZ + ", votre gain s'�l�ve � : " + premierparis.getGain() + " �") ;
		
	}
}