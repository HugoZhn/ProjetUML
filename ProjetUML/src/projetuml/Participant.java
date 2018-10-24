package projetuml;

public class Participant {

	private int noInscription ; 
	private Date dateInscription ;
	private double tempsFinal ;
	private boolean disqualifie;

	private Coureur coureur ;
	private Edition edition;
	private Vehicule vehicule ;


	public Participant (Vehicule vehiculeUtilise, Edition editionParticipe, Coureur coureurParticipant) {

		this.noInscription = editionParticipe.getParticipants().size() ;
		this.edition = editionParticipe ;
		editionParticipe.getParticipants().add(this);

		this.dateInscription = new Date() ; 
		this.vehicule = vehiculeUtilise ;
		this.coureur = coureurParticipant ;

		this.tempsFinal = 0;
		this.disqualifie = false;
	}

	public int getNoInscription() {
		return noInscription;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public double getTempsFinal() {
		this.calculerTempsFinal();
		return tempsFinal;
	}

	public double getCoeffCorrecteurVehicule(){
		return this.vehicule.getCoeffCorrecteur();
	}

	public boolean prendreDepart() {
		return !(this.disqualifie);
	}

	public void disqualifier(){
		this.disqualifie = true;
	}

	public void calculerTempsFinal(){
		if(!this.disqualifie){
			this.tempsFinal = 0;
			for(Etape et: this.edition.getEtapes()){
				if(et.getCourirTempsCorriges().containsKey(this)){
					this.tempsFinal += et.getCourirTempsCorriges().get(this);
				}
			}
		}
	}

	public String toString() {
		return "N° " + this.noInscription + " - " + this.coureur.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coureur == null) ? 0 : coureur.hashCode());
		result = prime * result + ((dateInscription == null) ? 0 : dateInscription.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + noInscription;
		result = prime * result + ((vehicule == null) ? 0 : vehicule.hashCode());
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
		Participant other = (Participant) obj;
		if (coureur == null) {
			if (other.coureur != null)
				return false;
		} else if (!coureur.equals(other.coureur))
			return false;
		if (dateInscription == null) {
			if (other.dateInscription != null)
				return false;
		} else if (!dateInscription.equals(other.dateInscription))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (noInscription != other.noInscription)
			return false;
		if (vehicule == null) {
			if (other.vehicule != null)
				return false;
		} else if (!vehicule.equals(other.vehicule))
			return false;
		return true;
	}
	
	

}
