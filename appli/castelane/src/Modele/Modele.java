package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modele.Bdd;

public class Modele {

	public static int verifConnexion (String login, String mdp)
	{
		int niveau = 0;
		String requete =" select count(*) as nb, niveau"
				+" from tiers"
				+" where login ='" +login+"' and"
				+" mdp = sha1('" + mdp +"');";
	
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
}
