package projetuml;

public abstract class Vehicule {
	protected String idVehicule;
	protected Parametres para;
	
	public Vehicule(String idV) {
		this.idVehicule = idV;
		this.para = new Parametres(0.05, 0.1);
	};
	
	public abstract double getCoeffCorrecteur();

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