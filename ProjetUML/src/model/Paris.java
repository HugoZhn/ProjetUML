package model;

public class Paris {

    private Coureur coureur;
    private int mise;
    private Edition editionConcerne;
    private Etape etapeconcerne;
    private static double beneficeffrag;

    /**
     * Paris concernant une édition complète non encore validée
     *
     * @param montantmise
     * @param coureurmise
     * @param editionc
     */
    public Paris(int montantmise, Coureur coureurmise, Edition editionc) {
        if (!editionc.isClassementValid()) {  //tant que le classement d'une édition n'est pas encore validé
            this.coureur = coureurmise;
            this.editionConcerne = editionc;
            this.mise = montantmise;
        }
    }

    /**
     * Paris concernant une étape non encore validée
     *
     * @param montantmise
     * @param coureurmise
     * @param editionc
     * @param etapec
     */
    public Paris(int montantmise, Coureur coureurmise, Edition editionc, Etape etapec) {
        if (!etapec.isClassementValid()) {  //tant que le classement d'une étape n'est pas encore validé donc connu
            this.coureur = coureurmise;
            this.editionConcerne = editionc;
            this.mise = montantmise;
            System.out.println("PROUT");
            System.out.println(etapec);
            this.etapeconcerne = etapec;
            
        }
    }

    /**
     * Cette fonction bingo permet de voir si la personne sur qui nous avons
     * misé est arrivé première de l'édition
     *
     * @return vrai si nous avons misé sur le vainqueur
     */
    public boolean bingo() {
        boolean jackpot = false;
        if (this.editionConcerne.isClassementValid()) {
            if (this.coureur == this.editionConcerne.connaitreVainqueur()) {
                jackpot = true;
            }
        }
        return jackpot;
    }

    /**
     * Cette fonction permet de recupérer le gain pour un coureur sur qui j'ai
     * parié. Mon gain est multiplié par 5 à chaque fois que ce coureur arrive
     * premier à une étape qui n'est pas obligatoirement validé Si toutefois ce
     * même coureur arrive premire de l'édition (apres confirmation du
     * classement) alors mon gain totale est multiplié par 50
     *
     * @return
     */
    public double getGainClassEtape() {
        double gains2 = 0;
        Etape etapeconcerne;
        int i;

        for (i = 0; i < editionConcerne.getEtapes().size(); i++) {
            if (this.coureur == editionConcerne.getEtapes().get(i).getClassement().get(0).getCoureur()) {
                gains2 = gains2 + this.mise * 2;

            }
        }

        if (this.editionConcerne.isClassementValid()) {
            if (this.coureur == this.editionConcerne.connaitreVainqueur()) {
                gains2 = gains2 * 50;

            }
        }
        beneficeffrag += gains2 * 0.15; //la ffrag récupere 15% des gains
        return gains2 * 0.85;

    }

    /**
     * Méthode permettant de trouver le gain lorsqu'on mise sur un vainqueur
     * d'une édition sans prendre en compte les étapes.
     *
     * @return
     */
    public double GainEdition() {
        double gainEd = 0;

        if (this.editionConcerne.isClassementValid()) {
            if (this.coureur == this.editionConcerne.connaitreVainqueur()) {
                gainEd = this.mise * 10;
            }
        }
        beneficeffrag += gainEd * 0.1; //La ffrag récupère 10% des gains dans le cas où on parie directement sur le vainqueur
        return gainEd * 0.9;
    }

    /**
     * Méthode permettant de trouver le gain lorsqu'on mise sur un vainqueur
     * d'une étape d'une édition
     *
     * @return
     */
    public double GainMiserEtape() {
        double gains3 = 0;
        if (this.etapeconcerne.isClassementValid()) {
            if (this.coureur == this.etapeconcerne.getClassement().get(0).getCoureur()) {
                gains3 = this.mise * 3;
            }
        }

        beneficeffrag += gains3 * 0.05;
        return gains3 * 0.95;
    }

    public static double getBeneficeffrag() {
        return beneficeffrag;
    }

    public Etape getEtapeconcerne() {
        return etapeconcerne;
    }

    public String toString() {
        return this.etapeconcerne.toString();
    }

    public void setEtapeconcerne(Etape etapeconcerne) {
        this.etapeconcerne = etapeconcerne;
    }

    public Coureur getCoureur() {
        return coureur;
    }

    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }

    public int getMise() {
        return mise;
    }

    public void setMise(int mise) {
        this.mise = mise;
    }

    public Edition getEditionConcerne() {
        return editionConcerne;
    }

    public void setEditionConcerne(Edition editionConcerne) {
        this.editionConcerne = editionConcerne;
    }

    public int nbbonnemise() {
        int nbmise = 0;
        int i = 0;
        for (i = 0; i < editionConcerne.getEtapes().size(); i++) {
            if (this.coureur == editionConcerne.getEtapes().get(i).getClassement().get(0).getCoureur()) {
                nbmise += 1;

            }
        }
        return nbmise;
    }

}
