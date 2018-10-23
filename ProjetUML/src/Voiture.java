
public class Voiture extends Vehicule{
	private int puissanceV;
	private int nbChevaux = 20;

	public Voiture(String idV, int puiV) {
		super(idV);
		this.puissanceV = puiV;
	}
	
	public float disparite() {
		float disV;
		int ecart;
		
		ecart = this.puissanceV-this.nbChevaux;
		disV = 1 + ecart* super.para.getCoefCorrectifV();
		return disV;
	}
}
