package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


import model.Camion;
import model.Coureur;
import model.Edition;
import model.Etape;
import model.Participant;
import model.Vehicule;
import model.Voiture;

public class DataExtractor {

	private Scanner scanner;
	private ArrayList<Vehicule> vehiculesBD;
	private ArrayList<Coureur> coureursBD;
        
        public DataExtractor(){
            this.coureursBD = new ArrayList<>();
        }
        
        public ArrayList<Coureur> getCoureursBD() {
            try{
                extractCoureurs();                
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            return coureursBD;
        }
	
        
	public void extractConn(Connexion conn, String filepath) throws FileNotFoundException{
		
		this.scanner = new Scanner(new File(filepath));
		
		int i = 0;		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fields = line.split(";");
			if(i!=0){
				String em = fields[0];
				String mdp = fields[1];
				String auth = fields[2];
				String role = fields[3];
				conn.addNewConn(em, mdp, auth, role);	
			}
			i++;
		}
		scanner.close();
	}	
	
        private void extractCoureurs() throws FileNotFoundException{
		this.scanner = new Scanner(new File("./data/Coureurs.csv"));
		scanner.nextLine();
                
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fields = line.split(";");
			String nom = fields[0];
			String prenom = fields[1];
			String dateNaissance = fields[2];
			String[] dateSplited = dateNaissance.split("/");
			Coureur newCoureur = new Coureur(nom, prenom, new Date(Integer.parseInt(dateSplited[0]), Integer.parseInt(dateSplited[1]), Integer.parseInt(dateSplited[2])),"O");
			this.coureursBD.add(newCoureur);
		}
	}
                
	public void extract(Edition editionConcernee, String filepath) throws FileNotFoundException{

		this.scanner = new Scanner(new File(filepath));
		ArrayList<Etape> etapes = new ArrayList<Etape>();

		String line = scanner.nextLine();
		String[] fields = line.split(";");

		for(int j=4; j<fields.length; j++){
			Etape et = new Etape(editionConcernee, 1500);
			etapes.add(et);
		}

		while(scanner.hasNextLine()){
			
			line = scanner.nextLine();
			fields = line.split(";");
			
			String[] noms = fields[0].split(" ");
			Coureur newCour = new Coureur(noms[0], noms[1], new Date(1,1,2000), "O");
			
			Voiture newVeh = new Voiture(fields[1], fields[2], 200);
			
			Participant newPart = new Participant(Integer.parseInt(fields[3]), newVeh, editionConcernee, newCour);
			
			for(int j=4; j<fields.length; j++){
				TimeParser chrono = new TimeParser(fields[j]);
				etapes.get(j-4).affecterTemps(newPart, chrono.getRealRepr());
			}
		}
		scanner.close();
	}

}
