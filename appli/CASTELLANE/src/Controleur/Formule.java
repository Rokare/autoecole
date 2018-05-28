package Controleur;

import java.util.Date;

public class Formule {
	
	private int idFormule;
	private String libelle, description;
	private Date dateDebut, dateFin;
	
	
	public Formule(int idFormule, String libelle, String description, Date dateDebut, Date dateFin) {
		this.idFormule = idFormule;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	public int getIdFormule() {
		return idFormule;
	}


	public void setIdFormule(int idFormule) {
		this.idFormule = idFormule;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
