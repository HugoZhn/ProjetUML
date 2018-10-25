package controler;

import java.util.*;
import java.io.*;

import utilitaire.Connexion;
import utilitaire.Auth;
import utilitaire.DataHandler;
import vue.*;

public class Controler {

    DataHandler dataH;
    Connexion conn;

    public Controler() {
        this.conn = new Connexion();
        this.dataH = new DataHandler();
    }

    public void connValider(String em, String mdp) {
        if (this.conn.checkConn(em, mdp)) {
            if (this.conn.getAuth(em).equals(Auth.COUREUR)) {
                VueInscriptions vInscr = new VueInscriptions(em);
                vInscr.setVisible(true);
            } else {
                System.err.println("ATTENTE!!!");
            }
        } else {
            VueConnexion vConn = new VueConnexion(true);
            vConn.setVisible(true);
        };
    }

    public void inscrireCompte() {
        VueInscrireCompte vIC = new VueInscrireCompte();
        vIC.setVisible(true);
    }

    public void deconnecter() {
        VueConnexion vConn = new VueConnexion(false);
        vConn.setVisible(true);
    }

    public void saveInscrireCompte(String em, String mdp, String nom, String prenom, String dateNaissance, String nationalite, String groupeS, String sexe) {
        PrintWriter pw;

        //save connxion
        String filepathConn = "./data/new/Connexion.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathConn, true));
            pw.println(em + ";" + mdp + ";" + Auth.COUREUR);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //save coureur
        String filepathC = "./data/new/Coureurs.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathC, true));
            pw.println(em + ";" + nom + ";" + prenom + ";" + dateNaissance + ";" + nationalite + ";" + groupeS + ";" + sexe);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        VueConnexion vConn = new VueConnexion(false);
        vConn.setVisible(true);
    }

    public void saveVehicule(String idV, String modele, String type, String puissance, String poids) {
        PrintWriter pw;

        String filepathVehicule = "./data/new/Vehicule.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathVehicule, true));
            if (type.equals("Voiture")) {
                poids = "0";
            } else if (type.equals("Camion")) {
                puissance = "0";
            }
            pw.println(idV + ";" + modele + ";" + type + ";" + puissance + ";" + poids);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void saveRallye(String nom, String ville, String pays){
        PrintWriter pw;

        String filepathVehicule = "./data/new/Rallye.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathVehicule, true));
            pw.println(nom + ";" + ville + ";" + pays);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void saveEdition(String nomRallye, String noEdition, String dateDeb, String dateFin){
        PrintWriter pw;

        String filepathVehicule = "./data/new/Rallye.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathVehicule, true));
            pw.println(nomRallye + ";" + noEdition + ";" + dateDeb + ";" + dateFin);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void saveParticipant(String nomRallye, String noEdition, String mail, String idVehicule){
        PrintWriter pw;

        String filepathVehicule = "./data/new/Rallye.csv";
        try {
            pw = new PrintWriter(new FileOutputStream(filepathVehicule, true));
            pw.println(nomRallye + ";" + noEdition + ";" + mail + ";" + idVehicule + "; En Attente");
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
