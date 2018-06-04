package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueGenerale extends JFrame implements ActionListener {
	private JPanel panelMenu = new JPanel();
	private JButton tabButtons [] = new JButton[4];
	private String tab[] = {"Gestion Candidats", "Gestion Moniteurs", "Gestion Planning"};
	
	
	
	//instanciation des panels
	private VueCandidat uneVueCandidat = new VueCandidat();
	private VueMoniteur uneVueMoniteur = new VueMoniteur();
	private VuePlanning uneVuePlanning = new VuePlanning();

	
	
	/********************************Le Constructeur***********************************/
	public VueGenerale() {
		this.setTitle("Logiciel de gestion des Plannings");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(800,640);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		//construction du panel menu
		this.panelMenu.setBounds(0, 0, 800, 30);
		this.panelMenu.setLayout(new GridLayout(1, 3));  //une ligne compos� de 4 cases
		
		//construction des buttons
		for(int i=0; i<this.tabButtons.length; i++)
		{
			this.tabButtons[i] = new JButton(this.tab[i]);
			this.panelMenu.add(this.tabButtons[i]);
			this.tabButtons[i].addActionListener(this);
		}
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		//ajout des panneaux
		this.add(this.uneVueCandidat);
		this.add(this.uneVueMoniteur);
		this.add(this.uneVuePlanning);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch (e.getActionCommand())
		{
		case "Gestion Candidats":
			this.uneVueCandidat.setVisible(true);
			this.uneVueMoniteur.setVisible(false);
			this.uneVuePlanning.setVisible(false);
			break;
		case "Gestion Moniteurs":
			this.uneVueCandidat.setVisible(false);
			this.uneVueMoniteur.setVisible(true);
			this.uneVuePlanning.setVisible(false);
			break;
		case "Gestion Planning":
			this.uneVueCandidat.setVisible(false);
			this.uneVueMoniteur.setVisible(false);
			this.uneVuePlanning.setVisible(true);
			break;
		}
		
	}

}
