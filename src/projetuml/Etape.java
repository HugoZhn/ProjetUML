package projetuml;

import java.util.ArrayList;
import java.util.HashMap;

public class Etape {

	private int codeEtape;
	private double distanceEtape;
	private boolean classementValid;

	private HashMap<Participant, Double> courir;
	private HashMap<Participant, Double> courirTempsCorriges;
	private ArrayList<Participant> classement;


	public Etape(int codeEtape, double distanceEtape) {
		this.codeEtape = codeEtape;
		this.distanceEtape = distanceEtape;
		this.classementValid = false;

		this.courir = new HashMap<Participant, Double>();
		this.courirTempsCorriges = new HashMap<Participant, Double>();
		this.classement = new ArrayList<>();
	}

	public void affecterTemps(Participant part, double temps){
		this.courir.put(part, temps);
	}

	public HashMap<Participant, Double> getCourir() {
		return courir;
	}
	
	public HashMap<Participant, Double> getCourirTempsCorriges() {
		this.corrigerTemps();
		return courirTempsCorriges;
	}

	public ArrayList<Participant> getClassement(){
		this.calculerClassement();
		return this.classement;
	}
	
	private void corrigerTemps(){
		for(Participant part: this.courir.keySet()){
			this.courirTempsCorriges.put(part, this.courir.get(part)*part.getDispariteVehicule());
		}
	}

	private void calculerClassement(){
		this.corrigerTemps();
		if(!classementValid){
			for(Participant part: this.courir.keySet()){
				this.classement.add(part);
			}
			boolean changement = true;
			while(changement){
				changement = false;
				for(int i=0; i<this.classement.size()-1; i++){
					if(this.courirTempsCorriges.get(this.classement.get(i)) > this.courirTempsCorriges.get(this.classement.get(i+1))){
						Participant tmp = this.classement.get(i);
						this.classement.remove(i);
						this.classement.add(i, this.classement.get(i+1));
						this.classement.remove(i+1);
						this.classement.add(i+1, tmp);
						changement = true;
					}
				}
			}
		}
	}

	public void validerClassement(){
		this.calculerClassement();
		this.classementValid = true;
	}


}
