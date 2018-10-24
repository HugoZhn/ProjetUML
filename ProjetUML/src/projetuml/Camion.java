package projetuml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Camion extends Vehicule {
	private double poidsV;

	public Camion(String idV, String mod, float pV) {
		super(idV, mod);
		this.poidsV = pV;
	}
	
	public double getCoeffCorrecteur() {
		return super.para.getCoefCorrectifC(this.poidsV);
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
        sb.append("0");
        sb.append(";");
        sb.append(String.valueOf(this.poidsV));
        pw.write(sb.toString());
        pw.close();
	}
}