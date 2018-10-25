package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Etape {

    private Edition etapeDe;
    private int codeEtape;
    private double distanceEtape;
    private boolean classementValid;

    private HashMap<Participant, Double> courir;
    private HashMap<Participant, Double> courirTempsCorriges;
    private ArrayList<Participant> classement;

    public Etape(Edition etapeDe, double distanceEtape) {
        this.codeEtape = etapeDe.getEtapes().size();
        etapeDe.getEtapes().add(this);
        this.etapeDe = etapeDe;
        this.distanceEtape = distanceEtape;
        this.classementValid = false;

        this.courir = new HashMap<Participant, Double>();
        this.courirTempsCorriges = new HashMap<Participant, Double>();
        this.classement = new ArrayList<>();
    }

    public int getCodeEtape() {
        return codeEtape;
    }

    public double getDistanceEtape() {
        return distanceEtape;
    }

    public boolean isClassementValid() {
        return classementValid;
    }

    public HashMap<Participant, Double> getCourir() {
        return courir;
    }

    public HashMap<Participant, Double> getCourirTempsCorriges() {
        return courirTempsCorriges;
    }

    public void affecterTemps(Participant part, double temps) {
        this.courir.put(part, temps);
        this.courirTempsCorriges.put(part, temps * part.getCoeffCorrecteurVehicule());
    }

    public ArrayList<Participant> getClassement() {
        this.calculerClassement();
        return this.classement;
    }

    private void calculerClassement() {
        if (!classementValid) {
            this.classement.clear();
            for (Participant part : this.courirTempsCorriges.keySet()) {
                if (part.prendreDepart()) {
                    this.classement.add(part);
                }
            }
            boolean changement = true;
            while (changement) {
                changement = false;
                for (int i = 0; i < this.classement.size() - 1; i++) {
                    if (this.courirTempsCorriges.get(this.classement.get(i)) > this.courirTempsCorriges.get(this.classement.get(i + 1))) {
                        Collections.swap(this.classement, i, i + 1);
                        changement = true;
                    }
                }
            }
        }
    }

    public void validerClassement() {
        this.calculerClassement();
        this.classementValid = true;
    }

    public String toString() {
        return String.valueOf(this.codeEtape + 1);
    }

}
