package Controleur;

import java.util.Date;

public class Revision {

	private int idRevision;
	private Vehicule unVehicule;
	private String libelle, motif;
	private Date dateRevision;
	
	
	public Revision(int idRevision, Vehicule unVehicule, String libelle, String motif, Date dateRevision) {
		
		this.idRevision = idRevision;
		this.unVehicule = unVehicule;
		this.libelle = libelle;
		this.motif = motif;
		this.dateRevision = dateRevision;
	}


	public int getIdRevision() {
		return idRevision;
	}


	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}


	public Vehicule getUnVehicule() {
		return unVehicule;
	}


	public void setUnVehicule(Vehicule unVehicule) {
		this.unVehicule = unVehicule;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public Date getDateRevision() {
		return dateRevision;
	}


	public void setDateRevision(Date dateRevision) {
		this.dateRevision = dateRevision;
	}
	
	
}
