/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.VueConnexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maxime
 */


public class Main implements ActionListener{

public static VueConnexion uneVueConnexion;
	public static void rendreVisible (boolean action)
	{
		Main.uneVueConnexion.setVisible(action);
	}
	
	
	public static void main(String[] args) {
		Main.uneVueConnexion = new VueConnexion();
		
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
