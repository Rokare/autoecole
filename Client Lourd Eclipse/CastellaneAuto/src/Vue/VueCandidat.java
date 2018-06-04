package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Candidat;
import Controleur.Tableau;

import datechooser.beans.DateChooserCombo;
import javafx.scene.control.PasswordField;
import Modele.*;
import Controleur.*;



public class VueCandidat extends JPanel implements ActionListener{
	
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btRechercheVille = new JButton("...");
	
	private JLabel matricule = new JLabel("Matricule :");
	private JLabel nom = new JLabel("Nom :");
	private JLabel prenom = new JLabel("Prenom :");
	private JLabel dateNaissance= new JLabel("Date de Naissance:");
	private JLabel adresse = new JLabel("Adresse :");
	private JLabel cp = new JLabel("Code Postal :");
	private JLabel ville = new JLabel("Ville :");
	private JLabel email = new JLabel("Email :");
	private JLabel telephone = new JLabel("Telephone :");
	private JLabel login = new JLabel("Login ");
	private JLabel mdp = new JLabel("Mot de passe :");
	private JLabel modePaiement = new JLabel("Mode paiement:");
	private JLabel typeCandidat = new JLabel("Type Candidat:");
	
	private JTextField txtMatricule = new JTextField();
	private JTextField txtNomCandidat = new JTextField();
	private JTextField txtPrenomCandidat = new JTextField();
	private JTextField txtAdresseCandidat = new JTextField();
	private JTextField txtCpCandidat = new JTextField();
	private JComboBox txtVilleCandidat = new JComboBox();
	private JTextField txtEmailCandidat = new JTextField();
	private JTextField txtTelephoneCandidat = new JTextField();
	private JTextField txtLoginCandidat = new JTextField();
	private JPasswordField txtMdpCandidat = new JPasswordField();
	private JComboBox txtModePaiement = new JComboBox();
	private DateChooserCombo dccDateNaissance = new DateChooserCombo();
	private JComboBox txtTypeCandidat = new JComboBox();
	
	
	
	
	private JLabel tabMatricule = new JLabel("Matricule :");
	private JLabel tabNom = new JLabel("Nom :");
	private JLabel tabPrenom = new JLabel("Prenom :");
	private JLabel tabEmail= new JLabel("Email:");
	private JLabel tabTelephone= new JLabel("Telephone:");
	
	
	private JTextField editNomCandidat = new JTextField();
	private JTextField editPrenomCandidat = new JTextField();
	private JTextField editTelephoneCandidat = new JTextField();
	private JTextField editEmailCandidat = new JTextField();
	private JTextField editMatriculeCandidat = new JTextField();
	
	private JPanel unPanelForm = new JPanel();
	private JPanel unPanelTab = new JPanel();
	
	
	
	//declaration d'une JTable
	private JTable tableCandidats;
	private Tableau unTableau; //objet Modele de la classe Tableau
	
	public VueCandidat() {
		this.setLayout(null);
		this.setBounds(0, 30, 800, 610);
		this.setVisible(false);
		
		//Panel Tableau
		unPanelTab.setLayout(null);
		unPanelTab.setBounds(0, 0, 550, 610);
	
		this.add(unPanelTab);
		
		//Panel Formulaire
		unPanelForm.setLayout(null);
		unPanelForm.setBounds(550, 0, 250, 610);
		unPanelForm.setBackground(Color.lightGray);
		this.add(unPanelForm);
	
		//Positionnement des JLabel dans le Panel Formulaire ainsi que le bouton Recherche Ville
		matricule.setBounds(10, 20, 100, 20);
		nom.setBounds(10, 60, 100, 20);
		prenom.setBounds(10, 100, 100, 20);
		dateNaissance.setBounds(10, 140, 120, 20);
		adresse.setBounds(10, 180, 100, 20);
		cp.setBounds(10, 220, 100, 20);
		ville.setBounds(10, 260, 40, 20);
		btRechercheVille.setBounds(100, 260, 20, 20);
		email.setBounds(10, 300, 100, 20);
		telephone.setBounds(10, 340, 100, 20);
		login.setBounds(10, 380, 100, 20);
		mdp.setBounds(10, 420, 100, 20);
		modePaiement.setBounds(10, 460, 100, 20);
		typeCandidat.setBounds(10, 500, 100, 20);
		
		//Ajout des JLabels dans le Formulaire
		unPanelForm.add(matricule);
		unPanelForm.add(nom);
		unPanelForm.add(prenom);
		unPanelForm.add(dateNaissance);
		unPanelForm.add(adresse);
		unPanelForm.add(cp);
		unPanelForm.add(ville);
		unPanelForm.add(btRechercheVille);
		unPanelForm.add(email);
		unPanelForm.add(telephone);
		unPanelForm.add(login);
		unPanelForm.add(mdp);
		unPanelForm.add(modePaiement);	
		unPanelForm.add(typeCandidat);
		
		//Positionnement des textFiels/ComboBox et DateChooserCombo
		txtMatricule.setBounds(125, 20, 100, 20);
		txtNomCandidat.setBounds(125, 60, 100, 20);
		txtPrenomCandidat.setBounds(125, 100, 100, 20);
		dccDateNaissance.setBounds(125, 140, 100, 20);
		txtAdresseCandidat.setBounds(125, 180, 100, 20);
		txtCpCandidat.setBounds(125, 220, 100, 20);
		txtVilleCandidat.setBounds(125, 260, 100, 20);
		txtEmailCandidat.setBounds(125, 300, 100, 20);
		txtTelephoneCandidat.setBounds(125, 340, 100, 20);
		txtLoginCandidat.setBounds(125, 380, 100, 20);
		txtMdpCandidat.setBounds(125, 420, 100, 20);
		txtModePaiement.setBounds(125, 460, 100, 20);
		txtTypeCandidat.setBounds(125, 500, 100, 20);
		
		//Ajout des TextFields etc
		unPanelForm.add(txtMatricule);
		unPanelForm.add(txtNomCandidat);
		unPanelForm.add(txtPrenomCandidat);
		unPanelForm.add(dccDateNaissance);
		unPanelForm.add(txtAdresseCandidat);
		unPanelForm.add(txtCpCandidat);
		unPanelForm.add(txtVilleCandidat);
		unPanelForm.add(txtEmailCandidat);
		unPanelForm.add(txtTelephoneCandidat);
		unPanelForm.add(txtLoginCandidat);
		unPanelForm.add(txtMdpCandidat);
		unPanelForm.add(txtModePaiement);
		unPanelForm.add(txtTypeCandidat);
	
		
		// ----------- PANEL TABLEAU ----------//
		
		
		
		
		this.btAjouter.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btRechercheVille.addActionListener(this);
		
	
		// buttons
		this.btAnnuler.setBounds(20, 500, 100, 30);
		this.btSupprimer.setBounds(130, 500, 100, 30);
		this.btEditer.setBounds(250, 500, 100, 30);
		this.btAjouter.setBounds(370, 500, 100, 30);
		
		// JTextFiel
		
		editMatriculeCandidat.setBounds(20, 450, 80, 20);
		editNomCandidat.setBounds(110, 450, 80, 20);
		editPrenomCandidat.setBounds(200, 450, 80, 20);
		editEmailCandidat.setBounds(290, 450, 80, 20);
		editTelephoneCandidat.setBounds(380, 450, 80, 20);
		this.editMatriculeCandidat.setEditable(false);
		// JLabel
		
		tabMatricule.setBounds(20, 420, 80, 30);
		tabNom.setBounds(110, 420, 80, 20);
		tabPrenom.setBounds(200, 420, 80, 20);
		tabEmail.setBounds(290, 420, 80, 20);
		tabTelephone.setBounds(380, 420, 80, 20);
		
		
		
		// ajout Jlabel
		unPanelTab.add(tabMatricule);
		unPanelTab.add(tabNom);
		unPanelTab.add(tabPrenom);
		unPanelTab.add(tabEmail);
		unPanelTab.add(tabTelephone);
		
		
		// ajout JTextField
		
		unPanelTab.add(editMatriculeCandidat);
		unPanelTab.add(editNomCandidat);
		unPanelTab.add(editPrenomCandidat);
		unPanelTab.add(editEmailCandidat);
		unPanelTab.add(editTelephoneCandidat);
		
		
		
		// ajout button
		unPanelTab.add(btAjouter);
		unPanelTab.add(btEditer);
		unPanelTab.add(btAnnuler);
		unPanelTab.add(btSupprimer);
		
		
		String entetes [] = {"Matricule","Nom","Prenom","Email","Telephone"} ;
		Object donnees [] [] = this.remplirDonnees();//object elle n'a pass de type, peut etre n'importe quoi
		//instaciation de la classe Tableau
		this.unTableau = new Tableau(donnees,entetes);
		//instanciaton de la jtable avec l'objet modele de table
		
		this.tableCandidats = new JTable(this.unTableau);
		JScrollPane uneScroll =new JScrollPane(tableCandidats);
		uneScroll.setBounds(10, 50, 500, 150);
		this.unPanelTab.add(uneScroll);
		
		this.tableCandidats.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = tableCandidats.getSelectedRow();
				editMatriculeCandidat.setText(tableCandidats.getValueAt(ligne, 0).toString());
				editNomCandidat.setText(tableCandidats.getValueAt(ligne, 1).toString());
				editPrenomCandidat.setText(tableCandidats.getValueAt(ligne, 2).toString());
				editEmailCandidat.setText(tableCandidats.getValueAt(ligne, 3).toString());
				editTelephoneCandidat.setText(tableCandidats.getValueAt(ligne, 4).toString());
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAjouter)
		{
			 String matricule = Modele.matricule();
	            
	            do{
	                 matricule = Modele.matricule();
	            }while(Modele.verifMatricule(matricule) == false);
	              
			String nom = this.txtNomCandidat.getText();
			String prenom = this.txtPrenomCandidat.getText();
			String email = this.txtEmailCandidat.getText();
			String telephone = this.txtTelephoneCandidat.getText();
			String login = this.txtLoginCandidat.getText();
			char[] password = this.txtMdpCandidat.getPassword();
			String mdp = new String(password);
			long date_n = this.dccDateNaissance.getSelectedDate().getTimeInMillis();
	        Date dateNaissance = new Date(date_n);
			Date dateInscription = new Date(System.currentTimeMillis());
		
			String cp = this.txtCpCandidat.getText();
			String adresse = this.txtAdresseCandidat.getText();
			String ville =this.txtVilleCandidat.getName();
			
			Ville uneVille = Modele.selectWhereVille(cp, ville);
			String modePaiement = this.txtModePaiement.getName();
			if (nom.equals("") || prenom.equals("") || email.equals("") || telephone.equals(""))
			{
				JOptionPane.showMessageDialog( this, "Veuillez remplir les données !");
			}
			else
			{
			//instanciation du client
			Candidat unCandidat = new Candidat(matricule,nom,prenom,adresse,login,mdp,email,telephone,dateNaissance,4,uneVille,dateInscription,modePaiement);
			//appel  du Modele pour inserer un client dans la BDD
			Modele.insertTiers(unCandidat);
			JOptionPane.showMessageDialog(this, "Insertion reussie !");
			unCandidat = (Candidat) Modele.selectWhereTiers(matricule);
			Object uneLigne[] = {unCandidat.getUnMatricule(), unCandidat.getNom(), unCandidat.getPrenom(), unCandidat.getEmail(),unCandidat.getTelephone()};
			this.unTableau.add(uneLigne);
			txtMatricule.setText("");
			txtNomCandidat.setText("");
			txtPrenomCandidat.setText("");
			dccDateNaissance.setText("");
			txtAdresseCandidat.setText("");
			txtCpCandidat.setText("");
			txtVilleCandidat.setSelectedIndex(0);
			txtEmailCandidat.setText("");
			txtTelephoneCandidat.setText("");
			txtLoginCandidat.setText("");
			txtMdpCandidat.setText("");
			txtModePaiement.setSelectedIndex(0);
			txtTypeCandidat.setSelectedIndex(0);
			}
		}else if(e.getSource() == this.btSupprimer)
		{
			
			if(editMatriculeCandidat.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner d'Id Client");
			}
			else {
				
			String matriculeCandidat = this.editMatriculeCandidat.getText();
			Candidat unCandidat = (Candidat) Modele.selectWhereTiers(matriculeCandidat);
			
			//appel  du Modele pour inserer un client dans la BDD
			Modele.deleteTiers(unCandidat);
			JOptionPane.showMessageDialog(this, "Suppression reussie !");
			
			//Supprime la ligne du tableau
            int ligne = this.tableCandidats.getSelectedRow();
            this.unTableau.delete(ligne);

            //Selectionne la ligne au dessus de celle supprimée et préremplit le formulaire
            this.selectLigne(ligne--);
			}
			
		}else if(e.getSource() == this.btEditer)
		{
			
			
			if(editMatriculeCandidat.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner le Matricule");
			}
			else {
				
			String matricule = this.editMatriculeCandidat.getText();
			String nom = this.editNomCandidat.getText();
			String prenom = this.editPrenomCandidat.getText();
			String email = this.editEmailCandidat.getText();
			String telephone = this.editTelephoneCandidat.getText();
			
			Candidat unCandidat = (Candidat) Modele.selectWhereTiers(matricule);
			unCandidat.setNom(nom);
			unCandidat.setPrenom(prenom);
			unCandidat.setEmail(email);
			unCandidat.setTelephone(telephone);
			//instanciation du client
			
			Modele.updateTiers(unCandidat);
			JOptionPane.showMessageDialog(this, "Mise à jour reussie !");
			}
		}else if(e.getSource() == this.btAnnuler)
		{
			this.editMatriculeCandidat.setText("");
			this.editNomCandidat.setText("");
			this.editPrenomCandidat.setText("");
			this.editTelephoneCandidat.setText("");
			this.editEmailCandidat.setText("");
		}
		
	}
	//Méthode sélectionnant la ligne et préremplissant le formulaire
    public void selectLigne(int ligne) {
        this.tableCandidats.setRowSelectionInterval(ligne, ligne);
        editMatriculeCandidat.setText(tableCandidats.getValueAt(ligne, 0).toString());
        editNomCandidat.setText(tableCandidats.getValueAt(ligne, 1).toString());
        editPrenomCandidat.setText(tableCandidats.getValueAt(ligne, 2).toString());
        editEmailCandidat.setText(tableCandidats.getValueAt(ligne, 3).toString());
        editTelephoneCandidat.setText(tableCandidats.getValueAt(ligne, 3).toString());
    }
	public Object [] [] remplirDonnees()
	{
		ArrayList<Candidat> lesCandidats = Modele.selectAllCandidats();
		Object donnees [] [] = new Object [lesCandidats.size()] [5];
		int i = 0;
		for (Candidat unCandidat : lesCandidats)
		{
			donnees[i] [0] = unCandidat.getUnMatricule() + "";
			donnees[i] [1] = unCandidat.getNom();
			donnees[i] [2] = unCandidat.getPrenom();
			donnees[i] [3] = unCandidat.getEmail();
			donnees[i] [4] = unCandidat.getTelephone();
			
			i++;
		}
		return donnees;
	}

}
