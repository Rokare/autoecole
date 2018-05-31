package Controleur;

import java.util.Date;

public class ExamenPratiqueHisto extends ExamenPratique{

	private Date dateHisto;

	public ExamenPratiqueHisto(String unType, String resultatP, Examen unExamen, Candidat unCandidat, Date dateP,
			Date dateHisto) {
		super(unType, resultatP, unExamen, unCandidat, dateP);
		this.dateHisto = dateHisto;
	}

	public Date getDateHisto() {
		return dateHisto;
	}

	public void setDateHisto(Date dateHisto) {
		this.dateHisto = dateHisto;
	}
	
	
}
