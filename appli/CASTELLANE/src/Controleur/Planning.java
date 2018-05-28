package Controleur;

public class Planning {

	private Vehicule unVehicule;
	private Moniteur unMoniteur;
	private Lecon uneLecon;
	private Candidat unCandidat;
	
	
	public Planning(Vehicule unVehicule, Moniteur unMoniteur, Lecon uneLecon, Candidat unCandidat) {
		this.unVehicule = unVehicule;
		this.unMoniteur = unMoniteur;
		this.uneLecon = uneLecon;
		this.unCandidat = unCandidat;
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
	
	
	
	
}
