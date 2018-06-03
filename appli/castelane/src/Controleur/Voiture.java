package Controleur;

import java.util.ArrayList;
import java.sql.Date;



public class Voiture extends Vehicule{

	private int nbPlace;
	private String conso;
	
	public Voiture(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat, String anneeMod, Date dateAchat,
			int nbPlace, String conso) {
		super(idVehicule, nbKiloIni, numImmatriculation, nomMod, etat, anneeMod, dateAchat);
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
        
        @Override
        public ArrayList<String> lesValeurs(){
            ArrayList<String> lesValeurs = super.lesValeurs();
            lesValeurs.add(String.valueOf(this.nbPlace));
            lesValeurs.add("'"+this.conso+"'");
            
            return lesValeurs;
        }
	
	
	
	
	
}
