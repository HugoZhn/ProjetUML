package projetuml;

public class Parametres {
	double coefCorrectifV;
	double coefCorrectifC;
	
	public Parametres(double cV, double cC) {
		this.coefCorrectifC = cC;
		this.coefCorrectifV = cV;
	}

	public double getCoefCorrectifV(int puissanceV) {
		int ecart = puissanceV-20;
		double disV = 1 + (ecart * this.coefCorrectifV);
		return disV;
	}

	public double getCoefCorrectifC(double poidsV) {
		int ecart = (int)((2000 - poidsV) / 100);
		double disC = 1 + (ecart * this.coefCorrectifC);
		return disC;
	}
	
}