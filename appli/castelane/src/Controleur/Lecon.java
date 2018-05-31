package Controleur;

import java.util.Date;

public class Lecon {

	private int idLecon;
	private String intitule, duree;
	private Date dateHd;
	
	
	public Lecon(int idLecon, String intitule, String duree, Date dateHd) {

		this.idLecon = idLecon;
		this.intitule = intitule;
		this.duree = duree;
		this.dateHd = dateHd;
	}


	public int getIdLecon() {
		return idLecon;
	}


	public void setIdLecon(int idLecon) {
		this.idLecon = idLecon;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}


	public Date getDateHd() {
		return dateHd;
	}


	public void setDateHd(Date dateHd) {
		this.dateHd = dateHd;
	}
	
	
	
	
}
