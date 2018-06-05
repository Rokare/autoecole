package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		txtModePaiement.addItem("Especes");
		txtModePaiement.addItem("CB");
		txtModePaiement.addItem("");
		txtTypeCandidat.addItem("Salarie");
		txtTypeCandidat.addItem("Etudiant");
		txtTypeCandidat.addItem("Autre");
	
		this.txtMatricule.setEditable(false);
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
				String matricule = tableCandidats.getValueAt(ligne, 0).toString();
				ArrayList<Candidat> lesCandidats = Modele.selectAllCandidats();
				Candidat unCandidat = candidatSelectionne(matricule, lesCandidats);
				remplirFormulaire(unCandidat);
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
			String ville =this.txtVilleCandidat.getSelectedItem().toString();
			
			Ville uneVille = Modele.selectWhereVille(cp, ville);
			String modePaiement = this.txtModePaiement.getSelectedItem().toString();
			if (nom.equals("") || prenom.equals("") || email.equals("") || telephone.equals("") || login.equals("") || mdp.equals(""))
			{
				JOptionPane.showMessageDialog( this, "Veuillez remplir les donnees !");
			}
			else
			{
				if(txtTypeCandidat.getSelectedItem().toString().equals("Etudiant")) {
					Etudiant unEtudiant = new Etudiant(matricule,nom,prenom,adresse,login,mdp,email,telephone,dateNaissance,4,uneVille,dateInscription,modePaiement, 1, 0.15);
					
					Modele.insertTiers(unEtudiant);
					JOptionPane.showMessageDialog(this, "Insertion reussie !");
					unEtudiant = (Etudiant) Modele.selectWhereTiers(matricule);
					Object uneLigne[] = {unEtudiant.getUnMatricule(), unEtudiant.getNom(), unEtudiant.getPrenom(), unEtudiant.getEmail(),unEtudiant.getTelephone()};
					this.unTableau.add(uneLigne);
					viderFormulaire();
				}
				
				else if(txtTypeCandidat.getSelectedItem().toString().equals("Salarie")) {
					Salarie unSalarie = new Salarie(matricule,nom,prenom,adresse,login,mdp,email,telephone,dateNaissance,4,uneVille,dateInscription,modePaiement,"A definir");
				
					Modele.insertTiers(unSalarie);
					JOptionPane.showMessageDialog(this, "Insertion reussie !");
					unSalarie = (Salarie) Modele.selectWhereTiers(matricule);
					Object uneLigne[] = {unSalarie.getUnMatricule(), unSalarie.getNom(), unSalarie.getPrenom(), unSalarie.getEmail(),unSalarie.getTelephone()};
					this.unTableau.add(uneLigne);
					viderFormulaire();
				}
				else {
					
					//instanciation du client
					Candidat unCandidat = new Candidat(matricule,nom,prenom,adresse,login,mdp,email,telephone,dateNaissance,4,uneVille,dateInscription,modePaiement);
					//appel  du Modele pour inserer un client dans la BDD
					Modele.insertTiers(unCandidat);
					JOptionPane.showMessageDialog(this, "Insertion reussie !");
					unCandidat = (Candidat) Modele.selectWhereTiers(matricule);
					Object uneLigne[] = {unCandidat.getUnMatricule(), unCandidat.getNom(), unCandidat.getPrenom(), unCandidat.getEmail(),unCandidat.getTelephone()};
					this.unTableau.add(uneLigne);
					viderFormulaire();
				}
				
			}
		}else if(e.getSource() == this.btSupprimer)
		{
			
			if(txtMatricule.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner d'Id Client");
			}
			else {
				
			String matriculeCandidat = this.txtMatricule.getText();
			Candidat unCandidat = (Candidat) Modele.selectWhereTiers(matriculeCandidat);
			
			//appel  du Modele pour inserer un client dans la BDD
			Modele.deleteTiers(unCandidat);
			JOptionPane.showMessageDialog(this, "Suppression reussie !");
			
			//Supprime la ligne du tableau
            int ligne = this.tableCandidats.getSelectedRow();
            this.unTableau.delete(ligne);

            //Selectionne la ligne au dessus de celle supprim�e et pr�remplit le formulaire
            this.selectLigne(ligne--);
			}
			
		}else if(e.getSource() == this.btEditer)
		{
			char[] password = this.txtMdpCandidat.getPassword();
			String mdp = new String(password);
			
			if(nom.equals("") || prenom.equals("") || email.equals("") || mdp.equals("") || telephone.equals("") || login.equals("") || mdp.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner le formulaire");
			}
			else {
			
			
			//instanciation du client
			//Modele.updateTiers(unCandidat);
			JOptionPane.showMessageDialog(this, "Mise a jour reussie !");
			}
		}else if(e.getSource() == this.btAnnuler)
		{
			viderFormulaire();
		}
		else if(e.getSource() == this.btRechercheVille) {
			rechercheVille(txtCpCandidat.getText());
		}
		
	}
	//M�thode s�lectionnant la ligne et pr�remplissant le formulaire
    public void selectLigne(int ligne) {
    	
    	this.tableCandidats.setRowSelectionInterval(ligne, ligne);
        String matricule = tableCandidats.getValueAt(ligne, 0).toString();
		ArrayList<Candidat> lesCandidats = Modele.selectAllCandidats();
		Candidat unCandidat = candidatSelectionne(matricule, lesCandidats);
		remplirFormulaire(unCandidat);
        
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
	
	public Candidat candidatSelectionne(String matricule, ArrayList<Candidat> lesCandidats) {
		Candidat unCandidat = null;
		for(Candidat leCandidat : lesCandidats) {
			if(leCandidat.getUnMatricule().equals(matricule)) {
				return leCandidat;
			}
		}
		
		return unCandidat;
	}
	
	public void remplirFormulaire(Candidat unCandidat) {
		
		txtMatricule.setText(unCandidat.getUnMatricule());
		txtNomCandidat.setText(unCandidat.getNom());
		txtPrenomCandidat.setText(unCandidat.getPrenom());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(unCandidat.getUneDateNaissance().toString()));
		}catch(ParseException exp) {
			System.out.println("Erreur parse de la date naissance");
		}
		dccDateNaissance.setSelectedDate(c);
		txtAdresseCandidat.setText(unCandidat.getAdresse());
		txtCpCandidat.setText(unCandidat.getUneVille().getCp());
		
		if(txtVilleCandidat.getItemCount() > 0) {
			for(int i=0; i < txtVilleCandidat.getItemCount(); i++) {
				if(!txtVilleCandidat.getItemAt(i).equals(unCandidat.getUneVille().getNomVille())){
					txtVilleCandidat.addItem(unCandidat.getUneVille().getNomVille());
					break;
				}
			}
		}
		else {
			txtVilleCandidat.addItem(unCandidat.getUneVille().getNomVille());
		}
		
		txtVilleCandidat.setSelectedItem(unCandidat.getUneVille().getNomVille());
		txtEmailCandidat.setText(unCandidat.getEmail());
		txtTelephoneCandidat.setText(unCandidat.getTelephone());
		txtLoginCandidat.setText(unCandidat.getLogin());
		txtMdpCandidat.setText("");
		if(!unCandidat.getModeFacturation().equals("CB") && !unCandidat.getModeFacturation().equals("Especes")){
			txtModePaiement.setSelectedIndex(2);
		}
		else {
			txtModePaiement.setSelectedItem(unCandidat.getModeFacturation());
		}
		if(unCandidat instanceof Salarie) {
			txtTypeCandidat.setSelectedIndex(0);
		}
		else if(unCandidat instanceof Etudiant) {
			txtTypeCandidat.setSelectedIndex(1);
		}
		else {
			txtTypeCandidat.setSelectedIndex(2);
		}
	}
	
	public void viderFormulaire() {
		txtMatricule.setText("");
		txtNomCandidat.setText("");
		txtPrenomCandidat.setText("");
		Calendar c = Calendar.getInstance();
		dccDateNaissance.setSelectedDate(c);
		txtAdresseCandidat.setText("");
		txtCpCandidat.setText("");
		txtVilleCandidat.removeAllItems();
		txtEmailCandidat.setText("");
		txtTelephoneCandidat.setText("");
		txtLoginCandidat.setText("");
		txtMdpCandidat.setText("");
		txtModePaiement.setSelectedIndex(0);
		txtModePaiement.setSelectedIndex(0);
		txtTypeCandidat.setSelectedIndex(0);
		
	}
	
	public void rechercheVille(String cp) {
		ArrayList<String> lesNomsVilles = Modele.selectWhereVille(cp);
		
		if(lesNomsVilles.size() > 0) {
			txtVilleCandidat.removeAllItems();
			for(String unNom : lesNomsVilles) {
				txtVilleCandidat.addItem(unNom);
			}
		}
		else {
			txtVilleCandidat.removeAllItems();
			JOptionPane.showMessageDialog(this, "Veuillez mettre un Code Postal valide.");
		}
		
	}
 
}
