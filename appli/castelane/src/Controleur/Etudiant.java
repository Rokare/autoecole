package Controleur;

import java.sql.Date;
import java.util.ArrayList;

public class Etudiant extends Candidat{

	private int nivEtudiant;
	private float reduc;
	
	public Etudiant(String unMatricule, String nom, String prenom, String adresse, String login, String mdp,
			String email, String telephone, Date uneDateNaissance, int unNiveau, Ville uneVille, Date dateInscription,
			String modeFacturation, int nivEtudiant, float reduc) {
		super(unMatricule, nom, prenom, adresse, login, mdp, email, telephone, uneDateNaissance, unNiveau, uneVille,
				dateInscription, modeFacturation);
		this.nivEtudiant = nivEtudiant;
		this.reduc = reduc;
	}

	
	public int getNivEtudiant() {
		return nivEtudiant;
	}

	public void setNivEtudiant(int nivEtudiant) {
		this.nivEtudiant = nivEtudiant;
	}

	public float getReduc() {
		return reduc;
	}

	public void setReduc(float reduc) {
		this.reduc = reduc;
	}
	
        @Override
        public ArrayList<String> lesValeurs(){
            
            ArrayList<String> lesValeurs = super.lesValeurs();
            lesValeurs.add(String.valueOf(this.nivEtudiant));
            lesValeurs.add(String.valueOf(this.reduc));
            
            return lesValeurs;
        }
	
	
}
