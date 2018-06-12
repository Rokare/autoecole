package Vue;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Candidat;
import Controleur.Tableau;
import Modele.Modele;

public class VueCandidat extends JPanel implements ActionListener {
	{
		private JButton btAjouter = new JButton ("Ajouter");
		private JButton btSupprimer = new JButton ("Supprimer");
		private JButton btEditer = new JButton ("Editer");
		private JButton btAnnuler = new JButton ("Annuler");
		
		private JTextField txtIdcandidat = new JTextField();
		private JTextField txtNomcandidat = new JTextField();
		private JTextField txtcandidat = new JTextField();
		private JComboBox txtTypecandidat = new JComboBox();
		
		private JPanel unPanel = new JPanel();
		//declaration d'une JTable
		private JTable tableCandidat;
		private Tableau unTableau; //objet du Modele de la classe Tableau
		
		public VueCandidats()
		{
			
			this.setLayout(null); 
			this.setBounds(50, 100, 600, 400);
			this.setBackground(Color.yellow);
			
			//contruction du panel d'administration
			this.unPanel.setLayout(new GridLayout (3,4));
			this.unPanel.setBounds(20, 180, 550, 200);
			this.unPanel.add(new JLabel ("Id Candidat"));
			this.unPanel.add(this.txtIdclient);
			
			this.txtIdclient.setEditable(false);
			
			this.unPanel.add(new JLabel ("Nom Candidat :"));
			this.unPanel.add(this.txtNomclient);
			
			this.unPanel.add(new JLabel ("Adresse Candidat :"));
			this.unPanel.add(this.txtAdresseclient);
			
			this.txtTypeclient.addItem("public");
			this.txtTypeclient.addItem("privé");
			
			this.unPanel.add(new JLabel ("Type Candidat :"));
			this.unPanel.add(this.txtTypeclient);
			
			this.unPanel.add(this.btAnnuler);
			this.unPanel.add(this.btAjouter);
			this.unPanel.add(this.btSupprimer);
			this.unPanel.add(this.btEditer);
			this.unPanel.setVisible(true);
			this.add(unPanel);
			
			this.btAjouter.addActionListener(this);
			this.btSupprimer.addActionListener(this);
			this.btEditer.addActionListener(this);
			this.btAnnuler.addActionListener(this);
			
			//insertion de la table dans la fenêtre
			String entetes [] = {"Id Candidat","Nom Candidat", "Adresse Candidat", "Type Candidat"};
			
			Object donnees [] [] = this.remplirDonnees();
			//instanciation de la classe Tableau
			this.unTableau = new Tableau (donnees, entetes);
			//instanciation de la jtable avec l'objet modele de table 
			this.tableClients = new JTable(this.unTableau);
			JScrollPane uneScroll = new JScrollPane (tableCandidats);
			uneScroll.setBounds(20, 20, 500, 150);
			this.add(uneScroll);
			
			//ajout  d'un environnement de click sur les lignes de la table 
			this.tableCandidats.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				
				@Override
				public void mousePressed(MouseEvent arg0) {}
				
				@Override
				public void mouseExited(MouseEvent arg0) {}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int ligne = tableClients.getSelectedRow();
					txtIdclient.setText(tableClients.getValueAt(ligne, 0).toString());
					txtNomclient.setText(tableClients.getValueAt(ligne, 1).toString());
					txtAdresseclient.setText(tableClients.getValueAt(ligne, 2).toString());
					txtTypeclient.setSelectedItem(tableClients.getValueAt(ligne, 3).toString());
					
				}
			});
			
			this.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
	      
			if(e.getSource() == this.btAjouter)
			{
				String nom = this.txtNomcandidat.getText();
				String adresse = this.txtAdressecandidat.getText();
				String typeClient = this.txtTypecandidat.getSelectedItem().toString();
				if (nom.equals("") || adresse.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez remplir les données !");
				}
				//instantiation du client
				
				Candidat unCandidat = new Candidat(nom, adresse, typeClient);
				//appel du Modele pour inserer un client dans la bdd
				Modele.insertCandidat(unCandidat);
				JOptionPane.showMessageDialog(this, "Insertion reussie !");
				unCandidat = Modele.selectWhereClient(unCandidat);
				Object uneLigne[] = {unCandidat.getIdcandidat(), unCandidat.getNom(), unCandidat.getAdresse(),
						unCandidat.getTypecandidat()};
				this.unTableau.add(uneLigne);
				this.txtNomcandidat.setText("");
				this.txtAdressecandidat.setText("");
				
			}else if (e.getSource() == this.btSupprimer)
			{
				
				if (txtIdcandidat.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez renseigner l'Id du Candidat");
				}else {
					int idclient = Integer.parseInt(this.txtIdcandidat.getText());
					String nom = this.txtNomcandidat.getText();
					String adresse = this.txtAdressecandidat.getText();
					String typeClient = this.txtTypecandidat.getSelectedItem().toString();
				
				
				//instantiation du candidat
				
					Candidat unCandidat = new Candidat(idCandidat, nom, adresse, typeCandidat);
				//appel du Modele pour inserer un client dans la bdd
				Modele.deleteCandidat(unCandidat);
				JOptionPane.showMessageDialog(this, "Suppression reussite !");
			}
			}else if (e.getSource() == this.btEditer)
			{
				if (txtIdclient.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez renseigner l'Id Candidat");
				}else {
					int idCandidat = Integer.parseInt(this.txtIdclient.getText());
					String nom = this.txtNomcandidat.getText();
					String adresse = this.txtAdressecandidat.getText();
					String typeClient = this.txtTypecandidat.getSelectedItem().toString();
				
				//instantiation du client
				
				Candidat unCandidat = new Candidat(idcandidat,nom, adresse, typeCandidat);
				//appel du Modele pour inserer un client dans la bdd
				Modele.updateCandidat(unCandidat);
				JOptionPane.showMessageDialog(this, "Mise à jour reussite !");
				}
			}else if (e.getSource() == this.btAnnuler)
			{
				this.txtIdcandidat.setText("");
				this.txtNomcandidat.setText("");
				this.txtAdressecandidat.setText("");
			}
		}
	    public Object [] [] remplirDonnee()
	    {
	    	ArrayList<Client> lesCandidat = Modele.selectAllCandidats();
	    	Object donnees [] [] = new Object [lesCandidats.size()] [4];
	    	int i = 0;
	    	for (Candidat unCandidat : lesCandidat)
	    	{
	    		donnees[i][0] = unCandidat.getIdcandidat() + "";
	    		donnees[i][1] = unCandidat.getNom();
	    		donnees[i][2] = unCandidat.getAdresse();
	    		donnees[i][3] = unCandidat.getTypecandidat();
	    		i++;
	    	}
	    	return donnees;
	    }
	}

}
