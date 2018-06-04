package Controleur;


import java.sql.Date;
import java.util.ArrayList;

public class Vehicule {
	
	protected int idVehicule, nbKiloIni;
	protected String numImmatriculation, nomMod, etat, anneeMod;
        protected Date dateAchat;
	
	public Vehicule(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat,
			String anneeMod, Date dateAchat) {
		
		this.idVehicule = idVehicule;
		this.nbKiloIni = nbKiloIni;
		this.numImmatriculation = numImmatriculation;
		this.nomMod = nomMod;
		this.etat = etat;
		this.anneeMod = anneeMod;
                this.dateAchat = dateAchat;
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

	public String getAnneeMod() {
		return anneeMod;
	}

	public void setAnneeMod(String anneeMod) {
		this.anneeMod = anneeMod;
	}
	
	public ArrayList<String> lesValeurs(){
            ArrayList<String> lesValeurs = new ArrayList<String>();
            lesValeurs.add(String.valueOf(this.idVehicule));
            lesValeurs.add("'"+this.numImmatriculation+"'");
            lesValeurs.add("'"+this.nomMod+"'");
            lesValeurs.add("'"+this.anneeMod+"'");
            lesValeurs.add("'"+this.dateAchat.toString()+"'");
            lesValeurs.add(String.valueOf(this.nbKiloIni));
            lesValeurs.add("'"+this.etat+"'");
            
            
            return lesValeurs;
        }
}
