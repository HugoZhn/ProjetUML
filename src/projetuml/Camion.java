package projetuml;

public class Camion extends Vehicule {
	private double poidsV;

	public Camion(String idV, float pV) {
		super(idV);
		this.poidsV = pV;
	}
	
	public double disparite() {
		return super.para.getCoefCorrectifC(this.poidsV);
	}
}