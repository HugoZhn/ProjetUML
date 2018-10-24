package projetuml;

import utilitaire.Date;

public class Coureur {

	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	private String nationalite;
	private String groupeSanguin;
	private String sexe;

	
	public Coureur(String nomCoureur, String prenomCoureur, Date dateNaissanceC, String nationalite, String groupeSanguin, String sexe) {
		this.nomCoureur = nomCoureur;
		this.prenomCoureur = prenomCoureur;
		this.dateNaissanceC = dateNaissanceC;
		this.nationalite= nationalite;
		this.groupeSanguin = groupeSanguin;
		this.sexe = sexe;
	}

	public String getNomCoureur() {
		return nomCoureur;
	}

	public String getPrenomCoureur() {
		return prenomCoureur;
	}

	public Date getDateNaissanceC() {
		return dateNaissanceC;
	}
	
	public String getNationalite() {
		return nationalite;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public String getSexe() {
		return sexe;
	}

	public String toString() {
		return this.prenomCoureur.toString() + " " + this.nomCoureur.toString() ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateNaissanceC == null) ? 0 : dateNaissanceC.hashCode());
		result = prime * result + ((nomCoureur == null) ? 0 : nomCoureur.hashCode());
		result = prime * result + ((prenomCoureur == null) ? 0 : prenomCoureur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coureur other = (Coureur) obj;
		if (dateNaissanceC == null) {
			if (other.dateNaissanceC != null)
				return false;
		} else if (!dateNaissanceC.equals(other.dateNaissanceC))
			return false;
		if (nomCoureur == null) {
			if (other.nomCoureur != null)
				return false;
		} else if (!nomCoureur.equals(other.nomCoureur))
			return false;
		if (prenomCoureur == null) {
			if (other.prenomCoureur != null)
				return false;
		} else if (!prenomCoureur.equals(other.prenomCoureur))
			return false;
		return true;
	}
	
	

}