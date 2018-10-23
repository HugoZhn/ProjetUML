
public class Camion extends Vehicule {
	private float poidsV;
	private int poids = 2000;
	private int tranche = 100;

	public Camion(String idV, float pV) {
		super(idV);
		this.poidsV = pV;
	}
	
	public float disparite() {
		float disV;
		int ecart;
		
		ecart = (int)(this.poids-this.poidsV)/this.tranche;
		disV = 1 + ecart* super.para.getCoefCorrectifC();
		return disV;
	}
}
