package Controleur;

import java.sql.Date;
import java.util.ArrayList;

public class Moto extends Vehicule{
	
	private int cylindre, puissance;

	public Moto(int idVehicule, int nbKiloIni, String numImmatriculation, String nomMod, String etat, String anneeMod, Date dateAchat,
			int cylindre, int puissance) {
		super(idVehicule, nbKiloIni, numImmatriculation, nomMod, etat, anneeMod, dateAchat);
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
	
	@Override
        public ArrayList<String> lesValeurs(){
            ArrayList<String> lesValeurs = super.lesValeurs();
            lesValeurs.add(String.valueOf(this.cylindre));
            lesValeurs.add(String.valueOf(this.puissance));
            
            return lesValeurs;
        }

}
