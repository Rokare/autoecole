package Controleur;

import java.sql.Date;
import java.util.ArrayList;

public class Candidat extends Tiers{

	protected Date dateInscription;
	protected String modeFacturation;
	
	
	public Candidat(String unMatricule, String nom, String prenom, String adresse, String login, String mdp,
			String email, String telephone, Date uneDateNaissance, int unNiveau, Ville uneVille, Date dateInscription,
			String modeFacturation) {
		
		super(unMatricule, nom, prenom, adresse, login, mdp, email, telephone, uneDateNaissance, unNiveau, uneVille);
		this.dateInscription = dateInscription;
		this.modeFacturation = modeFacturation;
	}


	public Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	public String getModeFacturation() {
		return modeFacturation;
	}


	public void setModeFacturation(String modeFacturation) {
		this.modeFacturation = modeFacturation;
	}
	
	@Override
        public ArrayList<String> lesValeurs(){
            
            ArrayList<String> lesValeurs = super.lesValeurs();
            lesValeurs.add(this.dateInscription.toString());
            lesValeurs.add(this.modeFacturation);
            
            return lesValeurs;
        }
	
}
