package projetuml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Statistiques {

	private double moyenneTempsEtape, bestTempsEtape, worstTempsEtape, ecartTypeEtape;
	private int nombreInscriptions, nombreReajustement;
	private Participant bestCoureurEtape, worstCoureurEtape;
	private Camion poidsV;



	public Statistiques() {
	}


	public double getMoyenneTempsEtape() {
		return moyenneTempsEtape;
	}

	public double getEcartTypeEtape() {
		return ecartTypeEtape;
	}

	public double getBestTempsEtape() {
		return bestTempsEtape;
	}

	public double getWorstTempsEtape() {
		return worstTempsEtape;
	}

	public int getNombreInscriptions() {
		return nombreInscriptions;
	}

	public int getNombreReajustement() {
		return nombreReajustement;
	}

	public Participant getBestCoureurEtape() {
		return bestCoureurEtape;
	}
	
	public Participant getWorstCoureurEtape() {
		return worstCoureurEtape;
	}

	//Calcul de la moyenne des temps d'une étape
	public double calculMoyenneEtape(Etape e){
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		moyenneTempsEtape=0;
		Iterator it;	
		if(courir!=null && courir.size()!=0) {
			it = courir.keySet().iterator();
			while(it.hasNext()) {
				moyenneTempsEtape = moyenneTempsEtape + courir.get(it.next());
			}	
			moyenneTempsEtape = moyenneTempsEtape / (courir.size());
		}
		return moyenneTempsEtape;
	}

	//Calcul de l'écart type des temps d'une étape
	public double calculEcartTypeEtape(Etape e) {
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		ecartTypeEtape=0;
		Iterator it;
		if(courir!=null && courir.size()!=0) {
			it = courir.keySet().iterator();
			while(it.hasNext()) {
				ecartTypeEtape = Math.pow(courir.get(it.next())-moyenneTempsEtape, 2);
			}
			ecartTypeEtape = ecartTypeEtape / courir.size();
			ecartTypeEtape = Math.sqrt(ecartTypeEtape);
		}
		return ecartTypeEtape;			
	}

	//Meilleur temps d'une étape
	public double bestTempsEtape(Etape e) {
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		bestTempsEtape = Double.POSITIVE_INFINITY;
		for(double temps : courir.values()) {
			if(temps<bestTempsEtape) {
				bestTempsEtape = temps;
			}
		}
		return bestTempsEtape;
	}

	//Meilleur coureur d'une étape
	public Participant bestCoureurEtape(Etape e) {
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		for (Entry<Participant, Double> entry : courir.entrySet()) {
			if (entry.getValue().equals(bestTempsEtape)) {
				bestCoureurEtape = entry.getKey();		
			}
		}
		return bestCoureurEtape;
	}


	//Moins bon temps d'une étape
	public double worstTempsEtape(Etape e) {
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		worstTempsEtape = 0;
		for(double temps : courir.values()) {
			if(temps>worstTempsEtape) {
				worstTempsEtape = temps;
			}
		}
		return worstTempsEtape;
	}

	//Moins bon coureur d'une étape
	public Participant worstCoureurEtape(Etape e) {
		HashMap<Participant, Double> courir=e.getCourirTempsCorriges();
		for (Entry<Participant, Double> entry : courir.entrySet()) {
			if (entry.getValue().equals(worstTempsEtape)) {
				worstCoureurEtape = entry.getKey();		
			}
		}
		return worstCoureurEtape;
	}

	//Nombre d'inscriptions sur une édition
	public int nombreInscriptions(Edition ed) {
		ArrayList<Participant> participants = ed.getParticipants();
		nombreInscriptions = participants.size();
		return nombreInscriptions;
	}


	/*public int nombreReajustement() {
		int nombredereajustement  = 0 ; 

		for() {
			nombredereajustement +=1 ;
		}
		return nombredereajustement;
	}*/

}
