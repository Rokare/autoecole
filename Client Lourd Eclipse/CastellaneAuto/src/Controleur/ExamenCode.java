package Controleur;

import java.util.Date;

public class ExamenCode {

	protected String unType, resultatC;
	protected Examen unExamen;
	protected Candidat unCandidat;
	protected Date dateC;
	
	public ExamenCode(String unType, String resultatC, Examen unExamen, Candidat unCandidat, Date dateC) {
		
		this.unType = unType;
		this.resultatC = resultatC;
		this.unExamen = unExamen;
		this.unCandidat = unCandidat;
		this.dateC = dateC;
	}

	public String getUnType() {
		return unType;
	}

	public void setUnType(String unType) {
		this.unType = unType;
	}

	public String getResultatC() {
		return resultatC;
	}

	public void setResultatC(String resultatC) {
		this.resultatC = resultatC;
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

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	
	
}
