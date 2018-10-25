package utilitaire;

import java.util.Calendar;

public class Date {

    private int jour;
    private int mois;
    private int annee;

    public Date() {
        Calendar today = Calendar.getInstance();
        this.jour = today.get(Calendar.DATE);
        this.mois = today.get(Calendar.MONTH) + 1;
        this.annee = today.get(Calendar.YEAR);
    }

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public Date(String dateStr) {
        String[] dateSplited = dateStr.split("/");
        this.jour = Integer.parseInt(dateSplited[0]);
        this.mois = Integer.parseInt(dateSplited[1]);
        this.annee = Integer.parseInt(dateSplited[2]);
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
        Date other = (Date) obj;
        if (this.jour != other.jour || this.mois != other.mois || this.annee != other.annee) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.annee * 10000 + this.mois * 100 + this.jour;
    }

    public String toString() {

        String jourStr = Integer.toString(this.jour);
        if (jourStr.length() == 1) {
            jourStr = "0" + jourStr;
        }

        String moisStr = Integer.toString(this.mois);
        if (moisStr.length() == 1) {
            moisStr = "0" + moisStr;
        }

        return jourStr + "/" + moisStr + "/" + annee;
    }
}
