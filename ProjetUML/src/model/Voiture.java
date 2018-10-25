package model;

public class Voiture extends Vehicule {

    private int puissanceV;

    public Voiture(String idV, String mod, int puiV) {
        super(idV, mod);
        this.puissanceV = puiV;
    }

    @Override
    public double getCoeffCorrecteur() {
        return super.para.getCoefCorrectifV(this.puissanceV);
    }
}
