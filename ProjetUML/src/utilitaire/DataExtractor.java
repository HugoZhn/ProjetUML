package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import projetuml.Coureur;
import projetuml.Edition;
import projetuml.Etape;
import projetuml.Participant;
import projetuml.Voiture;

public class DataExtractor {

	private Scanner scanner;

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
			Coureur newCour = new Coureur(noms[0], noms[1], new Date(1,1,2000));
			
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
