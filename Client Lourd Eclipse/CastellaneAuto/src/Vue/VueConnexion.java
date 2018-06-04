package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controleur.Main;
import Modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JLabel jlLogin = new JLabel("Login : ");
	private JLabel jlMdp = new JLabel("Mot de Passe : ");
	
	private JTextField txtLogin = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	
	
	public VueConnexion() {
		this.setTitle("Application GestAuto");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	    this.setSize(550, 250);
	    this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		//Disposition des TextFields et JLabel ainsi que des boutons
		jlLogin.setBounds(220, 50, 50, 20);
		jlMdp.setBounds(220, 100, 100, 20);
		txtLogin.setBounds(350, 50, 125, 20);
		txtMdp.setBounds(350, 100, 125, 20);
		btSeConnecter.setBounds(220, 150, 130, 20);
		btAnnuler.setBounds(375, 150, 100, 20);
		this.add(jlLogin);
		this.add(jlMdp);
		this.add(txtLogin);
		this.add(txtMdp);
		this.add(btSeConnecter);
		this.add(btAnnuler);
		
		
		//ajout de l'image logo dans la fenetre 
		ImageIcon logo = new ImageIcon("src/Images/adlauto.png");
		JLabel lbLogo = new JLabel(logo);
		lbLogo.setBounds(10, 16, 200, 179);
		this.add(lbLogo);
		
		//rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		this.txtLogin.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAnnuler)
		{
			this.txtLogin.setText("");
			this.txtMdp.setText("");
		}else if(e.getSource() == this.btSeConnecter)
		{
			traitement();
		}
		}
public void traitement()
{
	String login = this.txtLogin.getText();
	String mdp = new String(this.txtMdp.getPassword()); //le password recupere un tableau de caract�re donc new string
	//verification des identifiants dans la bdd
	int niveau = Modele.verifConnexion(login, mdp);
	
	if(niveau >= 2)
	{
		JOptionPane.showMessageDialog(this, "Acces non autorise.");
	}
	else if(niveau == 1) {
		JOptionPane.showMessageDialog(this, "Bienvenue !\n "
				+ "Compte administrateur");
		//demarage du logiciel en admin
		new VueGeneraleAdmin();
		Main.rendreVisible(false);//methode static
	}
	else if(niveau == 0) {
		JOptionPane.showMessageDialog(this, "Identifiants incorrects");
	}
	else
	{
		JOptionPane.showMessageDialog(this, "Bienvenue !\n ");
		
		//demarage du logiciel
		new VueGenerale();
		Main.rendreVisible(false);//methode static
	}
}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			traitement();
		}
			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
		
}


