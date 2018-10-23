
public abstract class Vehicule {
	protected String idVehicule;
	protected Parametres para;
	
	public Vehicule(String idV) {
		this.idVehicule = idV;
		this.para = new Parametres(0.05F, 0.01F);
	};
	
	public abstract float disparite();
}
