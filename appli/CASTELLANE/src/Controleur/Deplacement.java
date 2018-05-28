package Controleur;

public class Deplacement {

	private Vehicule unVehicule;
	private Mois unMois;
	private int nbKilometre;
	
	public Deplacement(Vehicule unVehicule, Mois unMois, int nbKilometre) {
		super();
		this.unVehicule = unVehicule;
		this.unMois = unMois;
		this.nbKilometre = nbKilometre;
	}

	public Vehicule getUnVehicule() {
		return unVehicule;
	}

	public void setUnVehicule(Vehicule unVehicule) {
		this.unVehicule = unVehicule;
	}

	public Mois getUnMois() {
		return unMois;
	}

	public void setUnMois(Mois unMois) {
		this.unMois = unMois;
	}

	public int getNbKilometre() {
		return nbKilometre;
	}

	public void setNbKilometre(int nbKilometre) {
		this.nbKilometre = nbKilometre;
	}
	
	
}
