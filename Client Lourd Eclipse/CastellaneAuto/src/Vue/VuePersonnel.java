package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VuePersonnel extends JPanel implements ActionListener{

	public VuePersonnel(){
		this.setLayout(null);
		this.setBounds(50, 180, 600, 150);
		this.setBackground(Color.red);
		
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
