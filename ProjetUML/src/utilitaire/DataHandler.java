package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import model.Camion;
import model.Coureur;
import model.Edition;
import model.Participant;
import model.Rallye;
import model.Vehicule;
import model.Voiture;

public class DataHandler {
    
    private Scanner scanner;
    private HashMap<String, Vehicule> vehicules;
    private HashMap<String, Coureur> coureurs;
    private HashMap<String, Rallye> rallyes;
    private HashMap<String, Edition> editions;
    private HashMap<String, Participant> participants;
    
    public DataHandler(){
        this.vehicules = new HashMap<String, Vehicule>();
        this.coureurs = new HashMap<String, Coureur>();
        this.rallyes = new HashMap<String, Rallye>();
        this.editions = new HashMap<String, Edition>();
        this.participants = new HashMap<String, Participant>();
        
        try{
            this.openDB();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void extractConn(Connexion conn) throws FileNotFoundException {
        this.scanner = new Scanner(new File("./data/new/Connexion.csv"));
        
        int i = 0;        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");
            if (i != 0) {
                String em = fields[0];
                String mdp = fields[1];
                String auth = fields[2];
                conn.addNewConn(em, mdp, auth);                
            }
            i++;
        }
        scanner.close();
    }
    
    public void openDB() throws FileNotFoundException {

        // Vehicules
        this.scanner = new Scanner(new File("./data/new/Vehicule.csv"));
        String line = scanner.nextLine();
        String[] fields;
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            fields = line.split(";");
            String idV = fields[0];
            String modele = fields[1];
            String type = fields[2];
            String puissance = fields[3];
            String poids = fields[4];
            if(type.equals("Voiture")){
                Voiture newV = new Voiture(idV, modele, Integer.parseInt(puissance));
                this.vehicules.put(idV, newV);
            }else if (type.equals("Camion")){
                Camion newC = new Camion(idV, modele, Integer.parseInt(poids));
                this.vehicules.put(idV, newC);
            }
        }
        
        // Coureurs
        this.scanner = new Scanner(new File("./data/new/Coureur.csv"));
        line = scanner.nextLine();
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            fields = line.split(";");
            String mail = fields[0];
            String nom = fields[1];
            String prenom = fields[2];
            String dateNaiss = fields[3];
            String nationalite = fields[4];
            String gpSang = fields[5];
            String sexe = fields[6];
            this.coureurs.put(mail, new Coureur(nom, prenom, new Date(dateNaiss), nationalite, gpSang, sexe));
            }
        
        // Rallyes
        this.scanner = new Scanner(new File("./data/new/Rallye.csv"));
        line = scanner.nextLine();
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            fields = line.split(";");
            String nom = fields[0];
            String ville = fields[1];
            String pays = fields[2];
            this.rallyes.put(nom, new Rallye(nom, ville, pays));
            }
        
        // Editions
        this.scanner = new Scanner(new File("./data/new/Edition.csv"));
        line = scanner.nextLine();
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            fields = line.split(";");
            String nomRallye = fields[0];
            String noEdition = fields[1];
            String datDeb = fields[2];
            String datFin = fields[3];
            Rallye thisRallye = null;
            for(Rallye ra : this.rallyes.values()){
                if(ra.getNomRallye().equals(nomRallye)){
                    thisRallye = ra;
                }
            }
            String cle = nomRallye + "_" + noEdition;
            this.editions.put(cle, new Edition(thisRallye, new Date(datDeb), new Date(datFin)));
            }
        
        // Participants
        this.scanner = new Scanner(new File("./data/new/Participant.csv"));
        line = scanner.nextLine();
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            fields = line.split(";");
            String noInscr = fields[0];
            String nomRallye = fields[1];
            String noEdition = fields[2];
            String email = fields[3];
            String idV = fields[4];
            
            Edition thisEdition = null;
            for(Edition ed : this.editions.values()){
                if(ed.getEditionDe().getNomRallye().equals(nomRallye) && ed.getNoEdition() == Integer.parseInt(noEdition)){
                    thisEdition = ed;
                }
            }
            
            Coureur thisCoureur = null;
            for(String cr : this.coureurs.keySet()){
                if(email.equals(cr)){
                    thisCoureur = this.coureurs.get(cr);
                }
            }
            
            Vehicule thisVehicule = null;
            for(String id : this.vehicules.keySet()){
                if(idV.equals(id)){
                    thisVehicule = this.vehicules.get(id);
                }
            }
            
            boolean etat = false;
            if(fields[5].equals("Validée")){
                etat = true;
            }
            
            String cle = nomRallye + "_" + noEdition;
            this.participants.put(email, new Participant(Integer.parseInt(noInscr), thisVehicule, thisEdition, thisCoureur, etat));
            }
    }
}
