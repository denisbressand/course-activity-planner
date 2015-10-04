package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.Gui;
import modele.Modele;

public class Controleur {

	private Modele modele;
	private JFrame vue;
	private ActionListener actionListener;
	private ChangeListener changeListener;

	public Controleur(Modele modele, JFrame vue) {
		this.modele = modele;
		this.vue = vue;

	}

	public void contol() {
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String path = ((Gui) vue).choixFic();
				ouvrirFic(path);
			}

		};

		changeListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				//statusLabel.setText("Value : " + ((JSpinner) e.getSource()).getValue());

			}
		};

		((Gui) vue).getButton().addActionListener(actionListener);
	}

	private void ouvrirFic(String path) {
		ArrayList<Calendar> listeDates = modele.recupererDates(path);

		((Gui) vue).afficherDates(listeDates);
		
	}
}
