package Modele;

import Controleur.Candidat;
import Controleur.Etudiant;
import Controleur.Lecon;
import Controleur.Moniteur;
import Controleur.Moto;
import Controleur.Personnel;
import Controleur.Planning;
import Controleur.Salarie;
import Controleur.Tiers;
import Controleur.Vehicule;
import Controleur.Ville;
import Controleur.Voiture;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modele.Bdd;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class Modele {

	public static int verifConnexion (String login, String mdp)
	{
		int niveau = 0;
		String requete =" select count(*) as nb, niveau"
				+" from tiers"
				+" where login ='" +login+"' and"
				+" mdp = sha1(" + mdp +");";
	
		Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int nb = unRes.getInt("nb");
				if(nb > 0)
				{
					niveau = unRes.getInt("niveau");
				}
				unStat.close();
				unRes.close();
				uneBdd.seDeConnecter();
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		catch(NullPointerException exp)
		{
			System.out.println("Erreur Connexion BDD non fonctionnelle !");
		}
		return niveau;
	}
        
        public static ArrayList<Tiers> selectAllTiers(){
            
            ArrayList<Tiers> lesTiers = new ArrayList<Tiers>();
            String requete = "select * from tiers;";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
                           lesTiers.add(selectWhereTiers(unRes.getString("matricule")));
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return lesTiers;
        }
        
        public static Tiers selectWhereTiers(String unMatricule){
            Tiers unTiers = null;
            String requete = "select * from tiers where matricule="+ unMatricule + ";";
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                            requete = "select * from ";
                            if(unRes.getInt("niveau") <= 2){
                                requete += "personnel;";
                                unRes =  unStat.executeQuery(requete);
                                unTiers = new Personnel(unRes.getString("matricule"),unRes.getString("nom"), unRes.getString("prenom"),unRes.getString("adresse"), unRes.getString("login"), unRes.getString("mdp"), unRes.getString("email"), unRes.getString("telephone"),unRes.getDate("date_n"), unRes.getInt("niveau"), selectWhereVille(unRes.getInt("niveau")), unRes.getDate("date_e"), unRes.getDate("date_fe"));
                                
                            }
                            
                            else if(unRes.getInt("niveau") == 3){
                                requete += "moniteur;";
                                unRes =  unStat.executeQuery(requete);
                                unTiers = new Moniteur(unRes.getString("matricule"),unRes.getString("nom"), unRes.getString("prenom"),unRes.getString("adresse"), unRes.getString("login"), unRes.getString("mdp"), unRes.getString("email"), unRes.getString("telephone"),unRes.getDate("date_n"), unRes.getInt("niveau"), selectWhereVille(unRes.getInt("niveau")), unRes.getDate("date_e"), unRes.getDate("date_fe"));
                               
                            }
                            
                            else if(unRes.getInt("niveau") == 4){
                                
                                if(estEtudiant(unRes.getString("matricule"))){
                                    requete += "etudiant;";
                                    unRes =  unStat.executeQuery(requete);
                                    unTiers = new Etudiant(unRes.getString("matricule"),unRes.getString("nom"), unRes.getString("prenom"),unRes.getString("adresse"), unRes.getString("login"), unRes.getString("mdp"), unRes.getString("email"), unRes.getString("telephone"),unRes.getDate("date_n"), unRes.getInt("niveau"), selectWhereVille(unRes.getInt("niveau")), unRes.getDate("date_i"), unRes.getString("mode_fact"), unRes.getInt("niv_etu"), unRes.getFloat("reduc"));
                                
                                }
                                else if(estSalarie(unRes.getString("matricule"))){
                                    requete += "salarie;";
                                    unRes =  unStat.executeQuery(requete);
                                    unTiers = new Salarie(unRes.getString("matricule"),unRes.getString("nom"), unRes.getString("prenom"),unRes.getString("adresse"), unRes.getString("login"), unRes.getString("mdp"), unRes.getString("email"), unRes.getString("telephone"),unRes.getDate("date_n"), unRes.getInt("niveau"), selectWhereVille(unRes.getInt("niveau")), unRes.getDate("date_i"), unRes.getString("mode_fact"), unRes.getString("nom_entrep"));
                                    
                                }
                                else{
                                    requete += "candidat;";
                                    unRes =  unStat.executeQuery(requete);
                                    unTiers = new Candidat(unRes.getString("matricule"),unRes.getString("nom"), unRes.getString("prenom"),unRes.getString("adresse"), unRes.getString("login"), unRes.getString("mdp"), unRes.getString("email"), unRes.getString("telephone"),unRes.getDate("date_n"), unRes.getInt("niveau"), selectWhereVille(unRes.getInt("niveau")), unRes.getDate("date_i"), unRes.getString("mode_fact"));
                                    
                                }
                            }
                           
				
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return unTiers;
        }
        
        public static Ville selectWhereVille(int idVille){
            
            Ville uneVille = null;
            String requete = "select * from ville where id_ville="+idVille+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           uneVille = new Ville(unRes.getInt("id_ville"),unRes.getString("cp"),unRes.getString("ville"));	
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
                
            return uneVille;
        }
        
        public static boolean estEtudiant(String unMatricule){
            boolean resultat = false;
            String requete = "select * from etudiant where matricule="+ unMatricule+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           resultat = true;
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return resultat;
        }
        
        
        public static boolean estSalarie(String unMatricule){
            boolean resultat = false;
            String requete = "select * from salarie where matricule="+ unMatricule+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           resultat = true;
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return resultat;
        }
        
        public static void updateTiers(Tiers unTiers){
            
            String table = "tiers";
            
            
            if(unTiers instanceof Personnel){
                table = "personnel";
            }
            
            else if(unTiers instanceof Moniteur){
                table = "moniteur";
            }
            
            else if(unTiers instanceof Candidat){
                table = "candidat";
            }
            
            else if(unTiers instanceof Etudiant){
                table = "etudiant";
            }
            
            else if(unTiers instanceof Salarie){
                table = "salarie";
            }
            
            
            String requete = "select * from "+table;
            ArrayList<String> lesColonnes = new ArrayList<String>();
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			ResultSetMetaData rsmd = unRes.getMetaData();
                        
                        for (int i = 1; i <= rsmd.getColumnCount(); i++ ) {
                            lesColonnes.add(rsmd.getColumnName(i));
                        }
                        
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            requete = "UPDATE "+ table + "SET ";
            ArrayList<Object> lesValeurs = unTiers.lesValeurs();
            
            for(int i = 1; i <= lesColonnes.size(); i++){
                if(i == lesColonnes.size()){
                    requete += lesColonnes.get(i) + "=" + lesValeurs.get(i) + " WHERE matricule=" + unTiers.getUnMatricule() + ";";
                }
                else{
                    requete += lesColonnes.get(i) + "=" + lesValeurs.get(i) + ",";
                }
            }
            
            execRequete(requete);
        }
        
        public static void deleteTiers(Tiers unTiers){
            
            String table = "tiers";
            
            
            if(unTiers instanceof Personnel){
                table = "personnel";
            }
            
            else if(unTiers instanceof Moniteur){
                table = "moniteur";
            }
            
            else if(unTiers instanceof Candidat){
                table = "candidat";
            }
            
            else if(unTiers instanceof Etudiant){
                table = "etudiant";
            }
            
            else if(unTiers instanceof Salarie){
                table = "salarie";
            }
            
            String requete = "DELETE FROM "+table+" WHERE matricule="+unTiers.getUnMatricule();
            
           execRequete(requete);
        }
        
        private static void execRequete(String requete)
	{
		Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			unStat.execute(requete);
			
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
	}
        
        public static boolean estMoto(int idVehicule){
            boolean resultat = false;
            String requete = "select * from moto where idVehicule="+ idVehicule+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           resultat = true;
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return resultat;
        }
        
        public static boolean estVoiture(int idVehicule){
            boolean resultat = false;
            String requete = "select * from voiture where idVehicule="+ idVehicule+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           resultat = true;
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return resultat;
        }
        
        public static Vehicule selectWhereVehicule(int idVehicule){
            Vehicule unVehicule = null;
            String requete = "select * from ";
            
            if(estMoto(idVehicule)){
                requete+= "moto where id_vehicule="+idVehicule+";";
                Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           unVehicule = new Moto(idVehicule, unRes.getInt("nb_kilo_ini"), unRes.getString("num_imma"), unRes.getString("nom_mod"), unRes.getString("etat"),unRes.getString("annee"), unRes.getInt("cylindres"),unRes.getInt("puissance"));
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            }
            
            else if(estVoiture(idVehicule)){
                requete+= "voiture where id_vehicule="+idVehicule+";";
                Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           unVehicule = new Voiture(idVehicule, unRes.getInt("nb_kilo_ini"), unRes.getString("num_imma"), unRes.getString("nom_mod"), unRes.getString("etat"),unRes.getString("annee"), unRes.getInt("nb_places"),unRes.getString("conso"));
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            }
            
            
            return unVehicule;
        }
        
        public static Lecon selectWhereLecon(int idLecon){
            Lecon uneLecon = null;
            String requete = "select * from lecon where id_lecon="+idLecon+";"; 
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
                        
                        if(unRes.next()){
                            
                            uneLecon = new Lecon(idLecon, unRes.getString("intitule"),unRes.getString("duree"),unRes.getDate("date_hd"), unRes.getTime("date_hd"));
                        }
                        
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return uneLecon;
        }
        
        
        public static ArrayList<Planning> selectAllPlanning(){
            ArrayList<Planning> lesPlannings = new ArrayList<Planning>();
            
            
            return lesPlannings;
        }
        
        public static Boolean verifMatricule(String matricule)
    {
        boolean verif = true;
            String requete = "select * from tiers where matricule="+ matricule+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
            
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
                           verif = false;
			}
                        
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return verif;
    }
    
    public static void InsertTiers(Tiers unTiers){
            
            String table = "tiers";
            
            
            if(unTiers instanceof Personnel){
                table = "personnel";
            }
            
            else if(unTiers instanceof Moniteur){
                table = "moniteur";
            }
            
            else if(unTiers instanceof Candidat){
                table = "candidat";
            }
            
            else if(unTiers instanceof Etudiant){
                table = "etudiant";
            }
            
            else if(unTiers instanceof Salarie){
                table = "salarie";
            }
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
                        
            String requete = "INSERT INTO "+ table + " VALUES(";
            ArrayList<Object> lesValeurs = unTiers.lesValeurs();
            
            for(int i = 1; i <= unTiers.lesValeurs().size(); i++){
                if(i == unTiers.lesValeurs().size()){
                    requete +=  lesValeurs.get(i) +  ");";
                }
                else{
                    requete += lesValeurs.get(i) + ",";
                }
            }
            
            execRequete(requete);
        }
    
    
     public static String  matricule()
        {
            int complexite = 3;
            int complexite2= 1;
            String mdp="";
            
             String chaine ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for(int i = 0; i< complexite; i++)
            {
                int c1 = (int)(Math.random()*(25-0))+0;
              mdp += chaine.charAt(c1);
            }
            for(int i = 0; i< complexite; i++)
            {
                int c2 = (int)(Math.random()*(51-26))+26;
              mdp += chaine.charAt(c2);
            }
            for(int i = 0; i< complexite2; i++)
            {
              int c3 = (int)(Math.random()*(61-52))+52;
              mdp += chaine.charAt(c3);
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
}
