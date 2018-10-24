package model;

import java.io.FileNotFoundException;

public abstract class Vehicule {
	protected String idVehicule;
	protected String modele;
	protected Parametres para;
	
	public Vehicule(String idV, String modele) {
		this.idVehicule = idV;
		this.modele = modele;
		this.para = new Parametres(0.005, 0.1);
	};
	
	public abstract double getCoeffCorrecteur();
	public abstract void save() throws FileNotFoundException;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVehicule == null) ? 0 : idVehicule.hashCode());
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
		Vehicule other = (Vehicule) obj;
		if (idVehicule == null) {
			if (other.idVehicule != null)
				return false;
		} else if (!idVehicule.equals(other.idVehicule))
			return false;
		return true;
	}
	
	
}