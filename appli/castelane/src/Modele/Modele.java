package Modele;

import Controleur.Candidat;
import Controleur.Datel;
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


import java.sql.ResultSetMetaData;
import java.util.ArrayList;

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
        public static Ville selectWhereVille(String cp, String ville){
            
            Ville uneVille = null;
            String requete = "select * from ville where cp="+cp+" and ville="+ville+" ;";
            
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
                            
                            uneLecon = new Lecon(idLecon, unRes.getString("intitule"),unRes.getString("duree"));
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
        
        public static Planning selectWherePlanning(String dateHeureFin, int idLecon, int idVehicule, String dateHeureDebut, String matriculeMoniteur, String matriculeCandidat ){
            Planning unPlanning = null;
            String requete = "select * from planning where date_hf="+dateHeureFin+" and id_lecon="+idLecon+" and id_vehicule="+idVehicule+" and dhd="+dateHeureDebut+" and mat_m="+matriculeMoniteur+" and mat_c="+matriculeCandidat+";";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
                        
                        if(unRes.next()){
                            unPlanning = new Planning(selectWhereVehicule(unRes.getInt("id_vehicule")),(Moniteur) selectWhereTiers(unRes.getString("mat_m")), selectWhereLecon(unRes.getInt("id_lecon")), (Candidat) selectWhereTiers(unRes.getString("mat_c")), new Datel(unRes.getDate("dhd"), unRes.getTime("dhd")), new Datel(unRes.getDate("date_hf"), unRes.getTime("date_hf")));
                        }
                        
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return unPlanning;
        }
        
        
        public static ArrayList<Planning> selectAllPlanning(){
            ArrayList<Planning> lesPlannings = new ArrayList<Planning>();
            String requete = "select * from planning";
            
            Bdd uneBdd = new Bdd("localhost", "adlauto", "root", "");
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
                           lesPlannings.add(selectWherePlanning(unRes.getString("date_hf"), unRes.getInt("id_lecon"), unRes.getInt("id_vehicule"), unRes.getString("dhd"), unRes.getString("mat_m"), unRes.getString("mat_c")));
			}
		unStat.close();
		unRes.close();
		uneBdd.seDeConnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur :" + requete);
		}
            
            return lesPlannings;
        }
        
        public static void insertPlanning(Planning unPlanning){
            
        }
        
        public static void updatePlanning(Planning unPlanning){
            
        }
        
        public static void deletePlanning(Planning unPlanning){
            
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
    
        public static void insertTiers(Tiers unTiers){
            
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
                        
            String requete = "INSERT INTO "+ table + " VALUES(";
         
            
            for(int i = 1; i <= unTiers.lesValeurs().size(); i++){
                if(i == unTiers.lesValeurs().size()){
                    requete +=  unTiers.lesValeurs().get(i) +  ");";
                }
                else{
                    requete += unTiers.lesValeurs().get(i) + ",";
                }
            }
            
            execRequete(requete);
        }
}
