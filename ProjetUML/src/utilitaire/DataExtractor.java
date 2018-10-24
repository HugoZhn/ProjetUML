package utilitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import projetuml.Coureur;
import projetuml.Date;
import projetuml.Edition;
import projetuml.Etape;
import projetuml.Participant;
import projetuml.Voiture;

public class DataExtractor {

	private Scanner scanner;

	public void extract(Edition editionConcernee, String filepath) throws FileNotFoundException{
		
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
				Voiture newVeh = new Voiture("Test", 20);
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


}
