package Controleur;

import java.util.ArrayList;


public class Lecon {

	private int idLecon;
	private String intitule, duree;
	
	
	public Lecon(int idLecon, String intitule, String duree) {

		this.idLecon = idLecon;
		this.intitule = intitule;
		this.duree = duree;
        }

	public int getIdLecon() {
		return idLecon;
	}


	public void setIdLecon(int idLecon) {
		this.idLecon = idLecon;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}
        
        public ArrayList<String> lesValeurs(){
            ArrayList<String> lesValeurs = new ArrayList<String>();
            lesValeurs.add(String.valueOf(this.idLecon));
            lesValeurs.add(this.intitule);
            lesValeurs.add(this.duree);
            
            return lesValeurs;
        }
            


	
	
	
}
