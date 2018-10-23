package projetuml;

public class Voiture extends Vehicule{
	private int puissanceV;

	public Voiture(String idV, int puiV) {
		super(idV);
		this.puissanceV = puiV;
	}
	
	public double getCoeffCorrecteur() {
		return super.para.getCoefCorrectifV(this.puissanceV);
	}
}