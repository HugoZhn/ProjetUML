package model;

public class Paris {
	private Coureur coureur;
	private int mise ;
	private Edition editionConcerne ;

	public Paris(int montantmise, Coureur coureurmise, Edition editionc){
		if(!editionc.isClassementValid()){
			this.coureur = coureurmise  ;
			this.editionConcerne = editionc;
			this.mise = montantmise;
		}
	}

	public int getGain () {
		int gains = 0; 	
		if(this.editionConcerne.isClassementValid()){
			if (this.coureur == this.editionConcerne.connaitreVainqueur()) {
				gains = this.mise * 50 ;
			}
		}
		return gains ;
	}
}
