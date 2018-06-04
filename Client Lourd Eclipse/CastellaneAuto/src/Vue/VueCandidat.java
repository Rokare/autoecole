package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Tableau;
import datechooser.beans.DateChooserCombo;
import javafx.scene.control.PasswordField;

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
	
	
	private JPanel unPanelForm = new JPanel();
	private JPanel unPanelTab = new JPanel();
	
	//declaration d'une JTable
	private JTable tableClients;
	private Tableau unTableau; //objet Modele de la classe Tableau
	
	public VueCandidat() {
		this.setLayout(null);
		this.setBounds(0, 30, 800, 610);
		this.setVisible(false);
		
		//Panel Tableau
		unPanelTab.setLayout(null);
		unPanelTab.setBounds(0, 0, 550, 610);
		unPanelTab.setBackground(Color.yellow);
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
	
		
		
		this.btAjouter.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btRechercheVille.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
