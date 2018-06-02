package Controleur;

import java.sql.Date;
import java.util.ArrayList;

public class Salarie extends Candidat{

	private String nomEntreprise;

	
	public Salarie(String unMatricule, String nom, String prenom, String adresse, String login, String mdp,
			String email, String telephone, Date uneDateNaissance, int unNiveau, Ville uneVille, Date dateInscription,
			String modeFacturation, String nomEntreprise) {
		super(unMatricule, nom, prenom, adresse, login, mdp, email, telephone, uneDateNaissance, unNiveau, uneVille,
				dateInscription, modeFacturation);
		this.nomEntreprise = nomEntreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	
	@Override
        public ArrayList<String> lesValeurs(){
            
            ArrayList<String> lesValeurs = super.lesValeurs();
            lesValeurs.add(this.nomEntreprise);
            
            return lesValeurs;
        }
}
