package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import projetuml.Camion;
import projetuml.Coureur;
import projetuml.Date;
import projetuml.Edition;
import projetuml.Etape;
import projetuml.Participant;
import projetuml.Vehicule;
import projetuml.Voiture;

public class DataExtractor {

	private Scanner scanner;
	private ArrayList<Vehicule> vehiculesBD;
	private ArrayList<Coureur> coureursBD;
	
	
	public DataExtractor() {
		this.vehiculesBD = new ArrayList<Vehicule>();
		coureursBD = new ArrayList<Coureur>();
	}
	

	public void extractVehicules() throws FileNotFoundException{
		this.scanner = new Scanner(new File("./data/Vehicules.csv"));
		scanner.nextLine();
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fields = line.split(";");
			String idV = fields[0];
			String modele = fields[1];
			if(fields[2]=="Voiture"){
				Voiture newVoiture = new Voiture(idV, modele, Integer.parseInt(fields[3]));
				this.vehiculesBD.add(newVoiture);
			}
			else{
				Camion newCamion = new Camion(idV, modele, Integer.parseInt(fields[4]));
				this.vehiculesBD.add(newCamion);
			}
		}
	}
	
	public void extractCoureurs() throws FileNotFoundException{
		this.scanner = new Scanner(new File("./data/Coureurs.csv"));
		scanner.nextLine();
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fields = line.split(";");
			String nom = fields[0];
			String prenom = fields[1];
			String dateNaissance = fields[2];
			String[] dateSplited = dateNaissance.split("/");
			Coureur newCoureur = new Coureur(nom, prenom, new Date(Integer.parseInt(dateSplited[0]), Integer.parseInt(dateSplited[1]), Integer.parseInt(dateSplited[2])));
			this.coureursBD.add(newCoureur);
		}
	}
	
	
	public void extractEdition(Edition editionConcernee, String filepath) throws FileNotFoundException{
		
		this.extractVehicules();
		this.extractCoureurs();
		
		this.scanner = new Scanner(new File(filepath));
		ArrayList<Etape> etapes = new ArrayList<Etape>();
		
		int i = 0;
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fields = line.split(";");
			if(i==0){
				for(int j=3; j<fields.length; j++){
					Etape et = new Etape(editionConcernee, 1500);
					etapes.add(et);
				}
			}else{
				String[] noms = fields[0].split(" ");
				Coureur newCour = new Coureur(noms[0], noms[1], new Date(1,1,2000));
				Participant newPart = new Participant(Integer.parseInt(fields[2]), newVeh, editionConcernee, newCour);
				for(int j=3; j<fields.length; j++){
					double nombre = 0.0;
					String[] temps = fields[j].split(":");
					nombre += Double.parseDouble(temps[0])*60;
					nombre += Double.parseDouble(temps[1]);
					nombre += Double.parseDouble(temps[2])/100;
					etapes.get(j-3).affecterTemps(newPart, nombre);
				}
			}
			i++;
		}
		scanner.close();
	}
	
	private Vehicule chercherVehicule(String idV){
		
	}


}
