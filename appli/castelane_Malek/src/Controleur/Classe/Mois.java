package Controleur;

import java.time.Year;

public class Mois {

	private int idMois;
	private Year annee;
	
	public Mois(int idMois, Year annee) {
		this.idMois = idMois;
		this.annee = annee;
	}

	public int getIdMois() {
		return idMois;
	}

	public void setIdMois(int idMois) {
		this.idMois = idMois;
	}

	public Year getAnnee() {
		return annee;
	}

	public void setAnnee(Year annee) {
		this.annee = annee;
	}
	
	
	
}
