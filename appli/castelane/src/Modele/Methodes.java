/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Candidat;
import Controleur.Etudiant;
import Controleur.Moniteur;
import Controleur.Personnel;
import Controleur.Salarie;
import Controleur.Tiers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Maxime
 */
public class Methodes {
    public Boolean verifMatricule(String matricule)
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
}
