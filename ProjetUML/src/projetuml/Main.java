package projetuml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.*;
import utilitaire.*;
import java.awt.*;
import javax.swing.*;
import vue.VueClassement;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Rallye Super Bresse et Val Thorens donnés
        OldDataExtractor deX = new OldDataExtractor();
        Rallye superBesse = new Rallye("Super Besse", "Lima", "Perou");
        Edition superBesse1 = new Edition(superBesse, new Date(26, 1, 2018), new Date(3, 3, 2018));

        int[] kilometres = {360, 325, 658, 157, 285, 423, 592, 227, 219, 280, 267, 302};
        for (int kilo : kilometres) {
            Etape newEt = new Etape(superBesse1, kilo);
        }

        System.out.println(superBesse1);

        deX.extract(superBesse1, "./data/old/SuperBesse.csv");

        int j = 1;
        for (Etape et : superBesse1.getEtapes()) {
            int i = 1;
            System.out.println("Etape " + j);
            for (Participant part : et.getClassement()) {
                System.out.print(i + " - ");
                TimeParser chrono = new TimeParser(et.getCourirTempsCorriges().get(part));
                TimeParser chronoNon = new TimeParser(et.getCourir().get(part));
                System.out.println(part + " : " + chrono + "(" + chronoNon + ")");
                i++;
            }
            System.out.println("\n");
            j++;
        }

        System.out.println("Classement définitif : \n");
        int i = 1;
        for (Participant part : superBesse1.getClassement()) {
            System.out.print(i + " - ");
            TimeParser chrono = new TimeParser(part.getTempsFinal());
            System.out.println(part + " : " + chrono);
            i++;
        }

        System.out.println("\n _________________________________ \n");

        Rallye valThorens = new Rallye("Val Thorens", "Val Thorens ", "France");
        Edition valThorens1 = new Edition(valThorens, new Date(8, 12, 2017), new Date(26, 1, 2018));

        int[] kilometresVT = {347, 305, 552, 180, 210, 380, 645, 325, 305, 179};
        for (int kilo : kilometresVT) {
            Etape newEt = new Etape(valThorens1, kilo);
        }

        System.out.println(valThorens1);

        deX.extract(valThorens1, "./data/old/ValThorens.csv");
        /*
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
         */
        System.out.println("Classement définitif : \n");
        i = 1;
        for (Participant part : valThorens1.getClassement()) {
            System.out.print(i + " - ");
            TimeParser chrono = new TimeParser(part.getTempsFinal());
            System.out.println(part + " : " + chrono);
            i++;
        }

        System.out.println("\n _________________________________ \n");

        System.out.println("Test classements intermédiaires");

        Date today = new Date();

        //Créer des coureurs
        Coureur HZ = new Coureur("Hugo", "Zahn", today, "France", "AB-", "H");
        Coureur KH = new Coureur("Kam", "Hachmi", today, "France", "A+", "F");
        Coureur UB = new Coureur("Usain", "Bolt", today, "Jamaique", "AB+", "H");

        //Créer les véhicules
        Voiture v1 = new Voiture("YGHT56", "Renault Clio", 200);
        Voiture v2 = new Voiture("VBDH12", "Renault Twingo", 180);
        Voiture v3 = new Voiture("TLKI74", "Peugeot 106", 220);

        //Créer les rallyes
        Rallye rallyeCarda = new Rallye("Rallye des Cardabelles", "Villeneuve-Aveyron", "France");

        //Créer les éditions
        Date dateFin = new Date(31, 10, 2018);
        Edition editionCardabelles = new Edition(rallyeCarda, today, dateFin);

        //Créer les étapes
        Etape etape1 = new Etape(editionCardabelles, 3200);
        Etape etape2 = new Etape(editionCardabelles, 1200);
        Etape etape3 = new Etape(editionCardabelles, 4000);
        Etape etape4 = new Etape(editionCardabelles, 2500);

        //Créer les participants
        Participant p1 = new Participant(v1, editionCardabelles, HZ);
        Participant p2 = new Participant(v2, editionCardabelles, KH);
        Participant p3 = new Participant(v3, editionCardabelles, UB);

        //On cherche le nom de l'édition
        System.out.println("Cette édition du " + editionCardabelles.getDateDebER() + " se nomme " + editionCardabelles.getEditionDe());

        System.out.println();

        etape1.affecterTemps(p1, 96);
        etape1.affecterTemps(p2, 186);

        System.out.println("Classement provisoire étape :");
        i = 1;
        for (Participant part : etape1.getClassement()) {
            System.out.print(i + " - ");
            TimeParser chrono = new TimeParser(etape1.getCourirTempsCorriges().get(part));
            System.out.println(part + " : " + chrono);
            i++;
        }

        etape1.affecterTemps(p3, 106);
        etape2.affecterTemps(p1, 120);
        etape2.affecterTemps(p2, 220);
        etape2.affecterTemps(p3, 320);
        etape3.affecterTemps(p3, 320);
        etape3.affecterTemps(p2, 220);
        etape3.affecterTemps(p1, 120);
        etape4.affecterTemps(p3, 320);
        etape4.affecterTemps(p1, 220);
        etape4.affecterTemps(p2, 120);

        int l = 0;
        for (l = 0; l < editionCardabelles.getEtapes().size(); l++) {
            System.out.println("\nClassement étape " + editionCardabelles.getEtapes().get(l).getCodeEtape());
            i = 1;
            for (Participant part : editionCardabelles.getEtapes().get(l).getClassement()) {
                System.out.print(i + " - ");
                TimeParser chrono = new TimeParser(editionCardabelles.getEtapes().get(l).getCourirTempsCorriges().get(part));
                System.out.println(part + " : " + chrono);
                i++;
            }
        }

        
        //Pari sur une étape d'une édition
        Paris pariEtape = new Paris(10, HZ, editionCardabelles, etape3); //je place un pari sur une étape de l'édition Cardabelles
        pariEtape.getEtapeconcerne().validerClassement();  //je valide l'étape
        System.out.println("\nVous avez placé un pari de " + pariEtape.getMise() + "€ sur " + pariEtape.getCoureur() + " pour l'étape " + pariEtape.toString() + " de l'édition " + pariEtape.getEditionConcerne() + ". Votre gain est de " + pariEtape.GainMiserEtape() + " €");

        Paris premierparis = new Paris(10, HZ, editionCardabelles);  //je place un pari sur une édition non encore validé 
        editionCardabelles.validerClassement(); // je valide cette même édition

        // Dans le cas où j'ai parié en prenant en compte les étapes
        if (premierparis.bingo() == false) {
            System.out.println("\nVous avez placé un pari prenant en compte les étapes d'un montant de " + premierparis.getMise() + "€ sur " + premierparis.getCoureur() + " pour l'édition " + premierparis.getEditionConcerne() + ". Votre coureur n'a pas remporté l'édition mais a gagné " + premierparis.nbbonnemise() + " étapes. Votre gain est donc de " + premierparis.getGainClassEtape() + " €");
        } else {
            System.out.println("\nBINGO!! Vous avez placé un pari prenant en compte les étapes d'un montant de " + premierparis.getMise() + "€ sur " + premierparis.getCoureur() + " pour l'édition " + premierparis.getEditionConcerne() + ". Votre coureur a remporté l'édition avec un total de  " + premierparis.nbbonnemise() + " étapes gagnés. Votre gain est donc de " + premierparis.getGainClassEtape() + " €");

        }

        //Dans le cas où j'ai parié seulement sur le vainqueur 
        System.out.println("\nVous avez placé un pari de " + premierparis.getMise() + "€ sur " + premierparis.getCoureur() + " pour l'édition " + premierparis.getEditionConcerne() + ".Votre gain est de " + premierparis.GainEdition() + " €");

        System.out.println("\nSuites aux paris, les bénéfices de la ffrag s'élèvent à " + premierparis.getBeneficeffrag() + "€");

        System.out.println();
        System.out.println("Nombre d'inscription à l'édition Cardabelles : " + Statistiques.nombreInscriptions(editionCardabelles));
        System.out.println();
        System.out.println("Moyenne temps etape 1: " + new TimeParser(Statistiques.calculMoyenneEtape(etape1)));
        System.out.println("Ecart type temps etape 1: " + new TimeParser(Statistiques.calculEcartTypeEtape(etape1)));
        System.out.println("Meilleur temps : " + new TimeParser(Statistiques.bestTempsEtape(etape1)) + ", pour le coureur " + Statistiques.bestCoureurEtape(etape1));
        System.out.println("Moins bon temps : " + new TimeParser(Statistiques.worstTempsEtape(etape1)) + ", pour le malheureux coureur " + Statistiques.worstCoureurEtape(etape1));
        System.out.println("Pourcentage d'hommes :" + Statistiques.repartitionHommesFemmes(editionCardabelles) + "%");
        System.out.println("La nationalité la plus représentée de l'édition est : " + Statistiques.nationalitePlusRepresentee(editionCardabelles));
        System.out.println();
        System.out.println("Nombre d'inscription à l'édition Val Thorens : " + Statistiques.nombreInscriptions(valThorens1));
        System.out.println("Moyenne temps etape 1 val thorens: " + new TimeParser(Statistiques.calculMoyenneEtape(valThorens1.getEtapes().get(0))));
        System.out.println("Meilleur temps : " + new TimeParser(Statistiques.bestTempsEtape(valThorens1.getEtapes().get(0))) + ", pour le coureur " + Statistiques.bestCoureurEtape(valThorens1.getEtapes().get(0)));
        System.out.println("Moins bon temps : " + new TimeParser(Statistiques.worstTempsEtape(valThorens1.getEtapes().get(0))) + ", pour le malheureux coureur " + Statistiques.worstCoureurEtape(valThorens1.getEtapes().get(0)));
        System.out.println("Pourcentage d'hommes : " + Statistiques.repartitionHommesFemmes(valThorens1) + "%");
        System.out.println("La nationalité la plus représentée de l'édition est : " + Statistiques.nationalitePlusRepresentee(valThorens1));

        Edition[] oldEditions = {valThorens1, superBesse1};

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VueClassement window = new VueClassement(oldEditions);
                    window.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
