package Controleur;

import java.time.Year;

public class Vehicule {
	
	protected int idVehicule, nbKiloIni;
	protected String numImmatriculation, nomMod, etat;
	protected Year anneeMod;
	
	public Vehicule(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat,
			Year anneeMod) {
		
		this.idVehicule = idVehicule;
		this.nbKiloIni = nbKiloIni;
		this.numImmatriculation = numImmatriculation;
		this.nomMod = nomMod;
		this.etat = etat;
		this.anneeMod = anneeMod;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public int getNbKiloIni() {
		return nbKiloIni;
	}

	public void setNbKiloIni(int nbKiloIni) {
		this.nbKiloIni = nbKiloIni;
	}

	public String getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public String getNomMod() {
		return nomMod;
	}

	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Year getAnneeMod() {
		return anneeMod;
	}

	public void setAnneeMod(Year anneeMod) {
		this.anneeMod = anneeMod;
	}
	
	
}
