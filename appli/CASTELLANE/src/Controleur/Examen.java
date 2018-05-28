package Controleur;

public class Examen {
	
	private int idExam;
	private Ville uneVille;
	private TypeExam unType;
	
	public Examen(int idExam, Ville uneVille, TypeExam unType) {
		super();
		this.idExam = idExam;
		this.uneVille = uneVille;
		this.unType = unType;
	}

	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	public Ville getUneVille() {
		return uneVille;
	}

	public void setUneVille(Ville uneVille) {
		this.uneVille = uneVille;
	}

	public TypeExam getUnType() {
		return unType;
	}

	public void setUnType(TypeExam unType) {
		this.unType = unType;
	}
	
	
}
