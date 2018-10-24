package projetuml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Voiture extends Vehicule{
	private int puissanceV;

	public Voiture(String idV, String mod, int puiV) {
		super(idV, mod);
		this.puissanceV = puiV;
	}
	
	public double getCoeffCorrecteur() {
		return super.para.getCoefCorrectifV(this.puissanceV);
	}
	
	public void save() throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("./data/Vehicules.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(this.idVehicule);
        sb.append(";");
        sb.append(this.modele);
        sb.append(";");
        sb.append("Voiture");
        sb.append(";");
        sb.append(String.valueOf(this.puissanceV));
        sb.append(";");
        sb.append("0");
        pw.write(sb.toString());
        pw.close();
	}
}