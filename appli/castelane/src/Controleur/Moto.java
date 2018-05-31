package Controleur;

import java.time.Year;

public class Moto extends Vehicule{
	
	private int cylindre, puissance;

	public Moto(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat, Year anneeMod,
			int cylindre, int puissance) {
		super(idVehicule, nbKiloIni, numImmatriculation, nomMod, etat, anneeMod);
		this.cylindre = cylindre;
		this.puissance = puissance;
	}

	public int getCylindre() {
		return cylindre;
	}

	public void setCylindre(int cylindre) {
		this.cylindre = cylindre;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
	

}
