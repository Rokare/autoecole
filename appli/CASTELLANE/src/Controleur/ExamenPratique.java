package Controleur;

import java.util.Date;

public class ExamenPratique {

	protected String unType, resultatP;
	protected Examen unExamen;
	protected Candidat unCandidat;
	protected Date dateP;
	
	
	public ExamenPratique(String unType, String resultatP, Examen unExamen, Candidat unCandidat, Date dateP) {
		
		this.unType = unType;
		this.resultatP = resultatP;
		this.unExamen = unExamen;
		this.unCandidat = unCandidat;
		this.dateP = dateP;
	}


	public String getUnType() {
		return unType;
	}


	public void setUnType(String unType) {
		this.unType = unType;
	}


	public String getResultatP() {
		return resultatP;
	}


	public void setResultatP(String resultatP) {
		this.resultatP = resultatP;
	}


	public Examen getUnExamen() {
		return unExamen;
	}


	public void setUnExamen(Examen unExamen) {
		this.unExamen = unExamen;
	}


	public Candidat getUnCandidat() {
		return unCandidat;
	}


	public void setUnCandidat(Candidat unCandidat) {
		this.unCandidat = unCandidat;
	}


	public Date getDateP() {
		return dateP;
	}


	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}
	
	
	
	
}
