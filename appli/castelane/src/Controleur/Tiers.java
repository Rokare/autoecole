package Controleur;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Tiers {

	protected String unMatricule, nom, prenom, adresse, login, mdp, email, telephone;
	protected Date uneDateNaissance;
	protected int unNiveau;
	protected Ville uneVille;
	
	
	public Tiers(String unMatricule, String nom, String prenom, String adresse, String login, String mdp, String email,
			String telephone, Date uneDateNaissance, int unNiveau, Ville uneVille) {
		
		
		this.unMatricule = unMatricule;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = login;
		this.mdp = mdp;
		this.email = email;
		this.telephone = telephone;
		this.uneDateNaissance = uneDateNaissance;
		this.unNiveau = unNiveau;
		this.uneVille = uneVille;
	}


	public String getUnMatricule() {
		return unMatricule;
	}


	public void setUnMatricule(String unMatricule) {
		this.unMatricule = unMatricule;
	}
        
        public String  matricule()
        {
            int complexite = 3;
            int complexite2= 1;
            String mdp="";
            
             String chaine ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for(int i = 0; i< complexite; i++)
            {
                int c1 = (int)(Math.random()*(25-0))+0;
              mdp += chaine.substring(c1);
            }
            for(int i = 0; i< complexite; i++)
            {
                int c2 = (int)(Math.random()*(51-26))+26;
              mdp += chaine.substring(c2);
            }
            for(int i = 0; i< complexite2; i++)
            {
              int c3 = (int)(Math.random()*(61-52))+52;
              mdp += chaine.substring(c3);
            }
            mdp= shuffle(mdp);//permet de mélanger les caractères,meetre dans le désordre
            return mdp;

        }
        
        
        public static String shuffle(String string) {
            StringBuilder sb = new StringBuilder(string.length());
            double rnd;
            for (char c: string.toCharArray()) {
                rnd = Math.random();
                if (rnd < 0.34)
                    sb.append(c);
                else if (rnd < 0.67)
                    sb.insert(sb.length() / 2, c);
                else
                    sb.insert(0, c);
            }       
            return sb.toString();
          }


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Date getUneDateNaissance() {
		return uneDateNaissance;
	}


	public void setUneDateNaissance(Date uneDateNaissance) {
		this.uneDateNaissance = uneDateNaissance;
	}


	public int getUnNiveau() {
		return unNiveau;
	}


	public void setUnNiveau(int unNiveau) {
		this.unNiveau = unNiveau;
	}


	public Ville getUneVille() {
		return uneVille;
	}


	public void setUneVille(Ville uneVille) {
		this.uneVille = uneVille;
	}
	
        public ArrayList<Object> lesValeurs(){
            
            ArrayList<Object> lesValeurs = new ArrayList<Object>();
            lesValeurs.add(this.unMatricule);
            lesValeurs.add(this.nom);
            lesValeurs.add(this.prenom);
            lesValeurs.add(this.adresse);
            lesValeurs.add(this.login);
            lesValeurs.add(this.mdp );
            lesValeurs.add(this.email);
            lesValeurs.add(this.telephone);
            lesValeurs.add(this.uneDateNaissance);
            lesValeurs.add(this.unNiveau);
            lesValeurs.add(this.uneVille.getIdVille());
            
            return lesValeurs;
        }
	
	
}
