package projetuml;

public class Main {

	public static void main(String[] args) {		
		Date today = new Date();
		System.out.println(today);
		
		//Créer des coureurs
		Coureur HZ= new Coureur("hugo", "Zahn", today);
		Coureur KH = new Coureur("Kam", "Hachmi", today);
		Coureur UB = new Coureur("Usain", "Bolt", today);
		Coureur cr4 = new Coureur("Jane", "HHHR", today);
		Coureur cr5 = new Coureur("Jin", "HHTD", today);
		Coureur cr6 = new Coureur("Jane", "RZRG", today);
		Coureur cr7 = new Coureur("Jke", "TRET", today);
		
		//Créer les véhicules
		Camion c1 = new Camion("QBC31", 1800);
		Camion c2 = new Camion("GFC58", 2000);
		Camion c3 = new Camion("QBO98", 2500);
		Voiture v1 =new Voiture("YGHT56", 20);
		Voiture v2 =new Voiture("VBDH12", 18);
		Voiture v3 =new Voiture("TLKI74", 25000);
		
		//Créer les rallyes
		Rallye r1=new Rallye("Rallye des Cardabelles", "Villeneuve-Aveyron","France");
		Rallye r2=new Rallye("Rallye du Tibet", "Lhassa","Tibet");
		
		//Créer les éditions
		Date demain = new Date(24,10,2018);
		Edition e1_r1 = new Edition(r1, today, demain);
		
		//Créer les étapes
		Etape etape1 = new Etape(e1_r1, 3200);
		
		//Créer les participants
		Participant p1=new Participant(v1,e1_r1,HZ);
		Participant p2=new Participant(c1,e1_r1,cr4);
		Participant p3=new Participant(v2,e1_r1,cr5);
		
		//On cherche le nom de l'édition
		System.out.println("Cette édition du " + e1_r1.getDateDebER() + " se nomme " + e1_r1.getEditionDe() );
		System.out.println("Les participants sont : " + e1_r1.getParticipants());
		
		etape1.affecterTemps(p1, 9.6);
		etape1.affecterTemps(p2, 18.6);
		etape1.affecterTemps(p3, 11.6);
		etape1.corrigerTemps();
		System.out.println(e1_r1.getClassement()) ;
	}

}