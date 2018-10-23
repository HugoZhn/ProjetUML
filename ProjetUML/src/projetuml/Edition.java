package projetuml;

import java.util.ArrayList;
import java.util.Collections;

public class Edition {

	private Rallye editionDe;
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private boolean classementValid;

	private ArrayList<Participant> participants;
	private ArrayList<Participant> classement;

	private ArrayList<Etape> etapes;


	public Edition(Rallye editionDe, Date dateDebER, Date dateFinER) {
		this.editionDe = editionDe;
		this.noEdition = editionDe.getEditions().size();
		editionDe.getEditions().add(this);
		this.dateDebER = dateDebER;
		this.dateFinER = dateFinER;
		this.classementValid = false;

		this.participants = new ArrayList<Participant>();
		this.classement = new ArrayList<Participant>();

		this.etapes = new ArrayList<Etape>();
	}

	public Rallye getEditionDe() {
		return editionDe;
	}

	public int getNoEdition() {
		return noEdition;
	}

	public Date getDateDebER() {
		return dateDebER;
	}

	public Date getDateFinER() {
		return dateFinER;
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	public ArrayList<Etape> getEtapes() {
		return etapes;
	}

	public ArrayList<Participant> getClassement(){
		this.calculerClassement();
		return this.classement;
	}

	private void calculerClassement(){
		if(!classementValid){
			this.classement.clear();
			for(Participant part: this.participants) {
				if(part.prendreDepart()) {
					this.classement.add(part);
				}
			}
			boolean changement = true;
			while(changement){
				changement = false;
				for(int i=0 ; i<this.classement.size()-1; i++){
					if(this.classement.get(i).getTempsFinal()>this.classement.get(i+1).getTempsFinal()){
						Collections.swap(this.classement, i, i+1);
						changement = true;
					}
				}
			}
		}
	}

	public void setClassement(ArrayList<Participant> classement) {
		this.classement = classement;
	}

	public void validerClassement(){
		this.calculerClassement();
		this.classementValid = true;
	}

	public String toString() {
		return this.editionDe.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebER == null) ? 0 : dateDebER.hashCode());
		result = prime * result + ((dateFinER == null) ? 0 : dateFinER.hashCode());
		result = prime * result + ((editionDe == null) ? 0 : editionDe.hashCode());
		result = prime * result + noEdition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edition other = (Edition) obj;
		if (dateDebER == null) {
			if (other.dateDebER != null)
				return false;
		} else if (!dateDebER.equals(other.dateDebER))
			return false;
		if (dateFinER == null) {
			if (other.dateFinER != null)
				return false;
		} else if (!dateFinER.equals(other.dateFinER))
			return false;
		if (editionDe == null) {
			if (other.editionDe != null)
				return false;
		} else if (!editionDe.equals(other.editionDe))
			return false;
		if (noEdition != other.noEdition)
			return false;
		return true;
	}




}
