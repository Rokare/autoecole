package Controleur;

import java.util.ArrayList;

public class Planning {

	private Vehicule unVehicule;
	private Moniteur unMoniteur;
	private Lecon uneLecon;
	private Candidat unCandidat;
        private Datel dateDebutLecon, dateFinLecon;
	
	
	public Planning(Vehicule unVehicule, Moniteur unMoniteur, Lecon uneLecon, Candidat unCandidat, Datel dateDebutLecon, Datel dateFinLecon) {
		this.unVehicule = unVehicule;
		this.unMoniteur = unMoniteur;
		this.uneLecon = uneLecon;
		this.unCandidat = unCandidat;
                this.dateDebutLecon = dateDebutLecon;
                this.dateFinLecon = dateFinLecon;
	}


	public Vehicule getUnVehicule() {
		return unVehicule;
	}


	public void setUnVehicule(Vehicule unVehicule) {
		this.unVehicule = unVehicule;
	}


	public Moniteur getUnMoniteur() {
		return unMoniteur;
	}


	public void setUnMoniteur(Moniteur unMoniteur) {
		this.unMoniteur = unMoniteur;
	}


	public Lecon getUneLecon() {
		return uneLecon;
	}


	public void setUneLecon(Lecon uneLecon) {
		this.uneLecon = uneLecon;
	}


	public Candidat getUnCandidat() {
		return unCandidat;
	}


	public void setUnCandidat(Candidat unCandidat) {
		this.unCandidat = unCandidat;
	}
        
        public Datel getDateDebutLecon(){
            return this.dateDebutLecon;
        }
	
        public void setDateDebutLecon(Datel dateDebutLecon){
            this.dateDebutLecon = dateDebutLecon;
        }
        
        public Datel getDateFinLecon(){
            return this.dateFinLecon;
        }
	
        public void setDateFinLecon(Datel dateFinLecon){
            this.dateFinLecon = dateFinLecon;
        }
	
	public ArrayList<String> lesValeurs(){
            ArrayList<String> lesValeurs = new ArrayList<String>();
            lesValeurs.add(this.dateFinLecon.toString());
            lesValeurs.add(String.valueOf(this.uneLecon.getIdLecon()));
            lesValeurs.add(String.valueOf(this.unVehicule.getIdVehicule()));
            lesValeurs.add(String.valueOf(this.dateDebutLecon.toString()));
            lesValeurs.add(this.unMoniteur.getUnMatricule());
            lesValeurs.add(this.unCandidat.getUnMatricule());
            
            return lesValeurs;
        }
	
}
