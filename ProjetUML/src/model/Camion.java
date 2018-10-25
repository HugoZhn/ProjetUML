package model;

public class Camion extends Vehicule {

    private double poidsV;

    public Camion(String idV, String mod, float pV) {
        super(idV, mod);
        this.poidsV = pV;
    }

    @Override
    public double getCoeffCorrecteur() {
        return super.para.getCoefCorrectifC(this.poidsV);
    }

}
