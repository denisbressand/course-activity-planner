import gui.Gui;

import javax.swing.JFrame;

import modele.Modele;



import controleur.Controleur;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Modele modele = new Modele();
		JFrame vue = new Gui();
		// View view = new View("-");
		Controleur controller = new Controleur(modele, vue);
		controller.control();

	}

}
