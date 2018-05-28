package Controleur;

public class TypeExam {

	private int idType;
	private String libelle;
	
	
	public TypeExam(int idType, String libelle) {

		this.idType = idType;
		this.libelle = libelle;
	}


	public int getIdType() {
		return idType;
	}


	public void setIdType(int idType) {
		this.idType = idType;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
