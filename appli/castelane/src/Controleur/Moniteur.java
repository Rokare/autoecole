package Controleur;

import java.sql.Date;
import java.util.ArrayList;

public class Moniteur extends Tiers{

	private Date dateEmbauche;
	private Date dateFin;
	
	public Moniteur(String unMatricule, String nom, String prenom, String adresse, String login, String mdp,
			String email, String telephone, Date uneDateNaissance, int unNiveau, Ville uneVille, Date dateEmbauche,
			Date dateFin) {
		super(unMatricule, nom, prenom, adresse, login, mdp, email, telephone, uneDateNaissance, unNiveau, uneVille);
		this.dateEmbauche = dateEmbauche;
		this.dateFin = dateFin;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
        @Override
        public ArrayList<Object> lesValeurs(){
            
            ArrayList<Object> lesValeurs = super.lesValeurs();
            lesValeurs.add(this.dateEmbauche);
            lesValeurs.add(this.dateFin);
            
            return lesValeurs;
        }
	
}
