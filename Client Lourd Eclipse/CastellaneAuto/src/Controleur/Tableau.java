package Controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel{

	
	private Object[][] donnees; //matrice des données
	private String entete[]; //entêtes des colonnes
	
	public Tableau(Object[][] donnees, String[] entete) {
		this.donnees = donnees;
		this.entete = entete;
	}
	
	@Override
	public int getColumnCount() {
		return this.entete.length;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//retourne l'élément de la matrice d'indices rowIndex & columnIndex
		return this.donnees[rowIndex][columnIndex];
	}
	
	public String getColumnName(int columnIndex) {
		return this.entete[columnIndex];
	}

	public void add(Object ligne[]) {
		Object newTable[][] = new Object[this.donnees.length + 1 ][this.entete.length];
		for(int i = 0; i < this.donnees.length; i++) {
			newTable[i] = this.donnees[i];
		}
		//Ajout de la ligne à la fin de la nouvelle matrice
		newTable[this.donnees.length] = ligne;
		//MAJ de la matrice
		this.donnees = newTable;
		//MAJ du graphique
		this.fireTableDataChanged();
	}
	
	public void delete(int rowIndex) {
		Object newTable[][] = new Object[this.donnees.length - 1][this.entete.length];
		//Itérateur permettant d'ordonner les lignes de la nouvelle table
		int j = 0;
		for(int i=0; i < this.donnees.length; i++) {
			//Si l'indice i est différent de celui de la ligne sélectionnée alors on ajoute les données à la nouvelle table et on incrémente j de 1
			if( i != rowIndex) {
				newTable[j] = this.donnees[i];
				j++;
			}
		}
		//MAJ de la matrice
		this.donnees = newTable;
		//MAJ du graphique
		this.fireTableDataChanged();
	}
	
	public void update(int rowIndex, Object ligne[]) {
		Object newTable[][] = new Object[this.donnees.length][this.entete.length];
		for(int i = 0; i < this.donnees.length; i++) {
			newTable[i] = this.donnees[i];
		}
		newTable[rowIndex] = ligne;
		//MAJ de la matrice
		this.donnees = newTable;
		//MAJ du graphique
		this.fireTableDataChanged();
	}
}
