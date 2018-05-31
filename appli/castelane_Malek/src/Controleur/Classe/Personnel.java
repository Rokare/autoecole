package Controleur;

import java.util.Date;

public class Personnel extends Tiers{

	private Date dateEmbauche;
	private Date dateFin;
	
	public Personnel(String unMatricule, String nom, String prenom, String adresse, String login, String mdp,
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
	
	
	
}