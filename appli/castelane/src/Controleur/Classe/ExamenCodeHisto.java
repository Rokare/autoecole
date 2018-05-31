package Controleur;

import java.util.Date;

public class ExamenCodeHisto extends ExamenCode{

	private Date dateHisto;

	public ExamenCodeHisto(String unType, String resultatC, Examen unExamen, Candidat unCandidat, Date dateC,
			Date dateHisto) {
		super(unType, resultatC, unExamen, unCandidat, dateC);
		this.dateHisto = dateHisto;
	}

	public Date getDateHisto() {
		return dateHisto;
	}

	public void setDateHisto(Date dateHisto) {
		this.dateHisto = dateHisto;
	}
	
	
}
