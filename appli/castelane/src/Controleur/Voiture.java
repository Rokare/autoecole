package Controleur;

import java.time.Year;

public class Voiture extends Vehicule{

	private int nbPlace;
	private String conso;
	
	public Voiture(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat, String anneeMod,
			int nbPlace, String conso) {
		super(idVehicule, nbKiloIni, numImmatriculation, nomMod, etat, anneeMod);
		this.nbPlace = nbPlace;
		this.conso = conso;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getConso() {
		return conso;
	}

	public void setConso(String conso) {
		this.conso = conso;
	}
	
	
	
	
	
}
