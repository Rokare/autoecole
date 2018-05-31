package Controleur;

public class Ville {
	
	private int idVille;
	private String cp, nomVille;



	public Ville(int idVille, String cp, String nomVille) {
		
		this.idVille = idVille;
		this.cp = cp;
		this.nomVille = nomVille;
	}



	public int getIdVille() {
		return idVille;
	}



	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}



	public String getCp() {
		return cp;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public String getNomVille() {
		return nomVille;
	}



	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	
	
	
}
