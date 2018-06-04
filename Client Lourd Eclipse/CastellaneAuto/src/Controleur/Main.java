/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import  Vue.VueConnexion;

public class Main {

	
	public static VueConnexion uneVueConnexion;
	public static void rendreVisible (boolean action)
	{
		Main.uneVueConnexion.setVisible(action);
	}
	
	
	public static void main(String[] args) {
		Main.uneVueConnexion = new VueConnexion();
	}

}
