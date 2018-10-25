package utilitaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import model.Edition;
import model.Etape;
import model.Participant;

public class Statistiques {

    //Calcul de la moyenne des temps d'une étape
    public static double calculMoyenneEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        double moyenneTempsEtape = 0;
        int i = 0;
        for (Double temps : courir.values()) {
            moyenneTempsEtape += temps;
            i++;
        }
        moyenneTempsEtape /= i;
        return moyenneTempsEtape;
    }

    //Calcul de l'écart type des temps d'une étape
    public static double calculEcartTypeEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        double ecartTypeEtape = 0;
        double moyenneTempsEtape = 0;
        Iterator it;
        if (courir != null && courir.size() != 0) {
            int i = 0;
            for (Double temps : courir.values()) {
                moyenneTempsEtape += temps;
                i++;
            }
            moyenneTempsEtape /= i;
            it = courir.keySet().iterator();
            while (it.hasNext()) {
                ecartTypeEtape = Math.pow(courir.get(it.next()) - moyenneTempsEtape, 2);
            }
            ecartTypeEtape = ecartTypeEtape / courir.size();
            ecartTypeEtape = Math.sqrt(ecartTypeEtape);
        }
        return ecartTypeEtape;
    }

    //Meilleur temps d'une étape
    public static double bestTempsEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        double bestTempsEtape = Double.POSITIVE_INFINITY;
        for (double temps : courir.values()) {
            if (temps < bestTempsEtape) {
                bestTempsEtape = temps;
            }
        }
        return bestTempsEtape;
    }

    //Meilleur coureur d'une étape
    public static Participant bestCoureurEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        Participant bestCoureurEtape = null;
        double bestTempsEtape = Double.POSITIVE_INFINITY;
        for (double temps : courir.values()) {
            if (temps < bestTempsEtape) {
                bestTempsEtape = temps;
            }
        }
        for (Entry<Participant, Double> entry : courir.entrySet()) {
            if (entry.getValue().equals(bestTempsEtape)) {
                bestCoureurEtape = entry.getKey();
            }
        }
        return bestCoureurEtape;
    }

    //Moins bon temps d'une étape
    public static double worstTempsEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        double worstTempsEtape = 0;
        for (double temps : courir.values()) {
            if (temps > worstTempsEtape) {
                worstTempsEtape = temps;
            }
        }
        return worstTempsEtape;
    }

    //Moins bon coureur d'une étape
    public static Participant worstCoureurEtape(Etape e) {
        HashMap<Participant, Double> courir = e.getCourirTempsCorriges();
        Participant worstCoureurEtape = null;
        double worstTempsEtape = 0;
        for (double temps : courir.values()) {
            if (temps > worstTempsEtape) {
                worstTempsEtape = temps;
            }
        }
        for (Entry<Participant, Double> entry : courir.entrySet()) {
            if (entry.getValue().equals(worstTempsEtape)) {
                worstCoureurEtape = entry.getKey();
            }
        }
        return worstCoureurEtape;
    }

    //Nombre d'inscriptions sur une édition
    public static int nombreInscriptions(Edition ed) {
        ArrayList<Participant> participants = ed.getParticipants();
        int nombreInscriptions = participants.size();
        return nombreInscriptions;
    }

    //Répartition hommes/femmes
    public static double repartitionHommesFemmes(Edition ed) {
        double nombreHommes = 0;
        int nombreFemmes = 0;
        ArrayList<Participant> participants = ed.getParticipants();
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getCoureur().getSexe().equals("H")) {
                nombreHommes = nombreHommes + 1;
            }
        }
        return (nombreHommes / participants.size()) * 100;
    }

    //Nationalité des candidats
    public static String nationalitePlusRepresentee(Edition ed) {
        String nationalitePlus = null;
        int nbrFR = 0;
        int nbrCN = 0;
        int nbrSS = 0;
        ArrayList<Participant> participants = ed.getParticipants();
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getCoureur().getNationalite().equals("France")) {
                nbrFR++;
            }
            if (participants.get(i).getCoureur().getNationalite().equals("Suisse")) {
                nbrSS++;
            }
            if (participants.get(i).getCoureur().getNationalite().equals("Canada")) {
                nbrCN++;
            }
            if (nbrFR > nbrSS && nbrFR > nbrCN) {
                nationalitePlus = "FRANCE";
            }
            if (nbrCN > nbrSS && nbrCN > nbrFR) {
                nationalitePlus = "CANADA";
            }
            if (nbrSS > nbrFR && nbrFR > nbrCN) {
                nationalitePlus = "SUISSE";
            }
        }
        return nationalitePlus;
    }
}
