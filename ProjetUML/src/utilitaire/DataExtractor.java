package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import projetuml.Coureur;
import projetuml.Edition;
import projetuml.Etape;
import projetuml.Participant;
import projetuml.Voiture;

public class DataExtractor {

	private Scanner scanner;

	private HashMap<String, Integer> extractPuissance() throws FileNotFoundException {
		HashMap<String, Integer> corres = new HashMap<String, Integer>();

		this.scanner = new Scanner(new File("./data/Puissances.csv"));

		String line = scanner.nextLine();

		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			String[] fields = line.split(";");
			corres.put(fields[0], Integer.parseInt(fields[1]));
		}
		return corres;
	}

	private ArrayList<Coureur> extractCoureurs() throws FileNotFoundException{
		ArrayList<Coureur> coureurs = new ArrayList<Coureur>();
		this.scanner = new Scanner(new File("./data/Coureurs.csv"));

		String line = scanner.nextLine();

		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			String[] fields = line.split(";");
			String[] names = fields[0].split(" ");
			String nom = names[1];
			String prenom = names[0];
			
			String[] dateSplited = fields[1].split("/");
			Date dateNaiss = new Date(Integer.parseInt(dateSplited[0]), Integer.parseInt(dateSplited[1]), Integer.parseInt(dateSplited[2]));
			
			String nat = fields[2];
			String gpSang = fields[3];
			String sexe = fields[4];
			
			coureurs.add(new Coureur(nom, prenom, dateNaiss, nat, gpSang, sexe));
		}
		return coureurs;
	}

	public void extract(Edition editionConcernee, String filepath) throws FileNotFoundException{
		HashMap<String, Integer> corresPuissance = this.extractPuissance();
		ArrayList<Coureur> coureursBD = this.extractCoureurs();

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
			Coureur newCour =  null;
			for(Coureur cour : coureursBD) {
				if(noms[1].equals(cour.getNomCoureur()) && noms[0].equals(cour.getPrenomCoureur())) {
					newCour = cour;
					break;
				}
			}

			int puissance = 200;
			if(corresPuissance.containsKey(fields[2])) {
				puissance = corresPuissance.get(fields[2]);
			}
			Voiture newVeh = new Voiture(fields[1], fields[2], puissance);

			Participant newPart = new Participant(Integer.parseInt(fields[3]), newVeh, editionConcernee, newCour);

			for(int j=4; j<fields.length; j++){
				TimeParser chrono = new TimeParser(fields[j]);
				etapes.get(j-4).affecterTemps(newPart, chrono.getRealRepr());
			}
		}
		scanner.close();
	}

}
