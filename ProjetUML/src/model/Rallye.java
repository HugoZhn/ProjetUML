package model;

import java.util.ArrayList;

public class Rallye {

    private String nomRallye;
    private String villeRallye;
    private String paysRallye;
    private ArrayList<Edition> editions;

    public Rallye(String nomRallye, String villeRallye, String paysRallye) {
        this.nomRallye = nomRallye;
        this.villeRallye = villeRallye;
        this.paysRallye = paysRallye;
        this.editions = new ArrayList<Edition>();
    }

    public String getNomRallye() {
        return nomRallye;
    }

    public String getVilleRallye() {
        return villeRallye;
    }

    public String getPaysRallye() {
        return paysRallye;
    }

    public ArrayList<Edition> getEditions() {
        return editions;
    }

    public String toString() {
        return "\"" + this.nomRallye + "\" de " + this.villeRallye + ", " + this.paysRallye;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomRallye == null) ? 0 : nomRallye.hashCode());
        result = prime * result + ((paysRallye == null) ? 0 : paysRallye.hashCode());
        result = prime * result + ((villeRallye == null) ? 0 : villeRallye.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Rallye other = (Rallye) obj;
        if (nomRallye == null) {
            if (other.nomRallye != null) {
                return false;
            }
        } else if (!nomRallye.equals(other.nomRallye)) {
            return false;
        }
        if (paysRallye == null) {
            if (other.paysRallye != null) {
                return false;
            }
        } else if (!paysRallye.equals(other.paysRallye)) {
            return false;
        }
        if (villeRallye == null) {
            if (other.villeRallye != null) {
                return false;
            }
        } else if (!villeRallye.equals(other.villeRallye)) {
            return false;
        }
        return true;
    }
}
