package projetuml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Etape {

	private Edition etapeDe;
	private int codeEtape;
	private double distanceEtape;
	private boolean classementValid;

	private HashMap<Participant, Double> courir;
	private HashMap<Participant, Double> courirTempsCorriges;
	private ArrayList<Participant> classement;


	public Etape(Edition etapeDe, double distanceEtape) {
		this.codeEtape = etapeDe.getEtapes().size();
		etapeDe.getEtapes().add(this);
		this.etapeDe = etapeDe;
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
		return courirTempsCorriges;
	}

	public ArrayList<Participant> getClassement(){
		this.calculerClassement();
		return this.classement;
	}
	
	public void corrigerTemps(){
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
						Collections.swap(this.classement, i, i+1);
						
//						Participant tmp = this.classement.get(i);
//						this.classement.remove(i);
//						this.classement.add(i, this.classement.get(i+1));
//						this.classement.remove(i+1);
//						this.classement.add(i+1, tmp);
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
