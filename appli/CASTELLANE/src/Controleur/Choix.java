package Controleur;

import java.util.Date;

public class Choix {

	private Formule uneFormule;
	private Candidat unCandidat;
	private Date dateSouscription;
	
	public Choix(Formule uneFormule, Candidat unCandidat, Date dateSouscription) {
		this.uneFormule = uneFormule;
		this.unCandidat = unCandidat;
		this.dateSouscription = dateSouscription;
	}

	public Formule getUneFormule() {
		return uneFormule;
	}

	public void setUneFormule(Formule uneFormule) {
		this.uneFormule = uneFormule;
	}

	public Candidat getUnCandidat() {
		return unCandidat;
	}

	public void setUnCandidat(Candidat unCandidat) {
		this.unCandidat = unCandidat;
	}

	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}
	
	
}
