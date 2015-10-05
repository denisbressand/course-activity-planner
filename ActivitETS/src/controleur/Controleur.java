package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Activites.Quiz;
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

	public void control() {
		actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if(actionEvent.getSource() == ((Gui) vue).getBtnFic()) {
					String path = ((Gui) vue).choixFic();
					ouvrirFic(path);
					afficherInfos();
				} else if(actionEvent.getSource() == ((Gui) vue).getBtnCreateFic()) {
					String pathNewFile = "QuizzMoodle\\activities\\quizTest.xml";
					ArrayList<LocalDateTime> listesNewDates = ((Gui) vue).getNewDates();
					generateNewFile(listesNewDates, pathNewFile);
				}
				
			}

		};

		changeListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				//statusLabel.setText("Value : " + ((JSpinner) e.getSource()).getValue());
				System.out.println("Changement de date");
			}
		};

		((Gui) vue).getBtnFic().addActionListener(actionListener);
		((Gui) vue).getBtnCreateFic().addActionListener(actionListener);
	}

	private void ouvrirFic(String path) {
		if(path.contains("quiz.xml")) {
			ArrayList<LocalDateTime> listeDates = modele.recupererDates(path);

			((Gui) vue).afficherDates(listeDates);
		} else {
			((Gui) vue).afficherEreurFichier();
		}

		
	}
	
	private void afficherInfos() {
		
		Quiz quiz = modele.recupererInfos();
		((Gui) vue).afficherInfos(quiz);
	}
	
	private void generateNewFile(ArrayList<LocalDateTime> listesNewDates, String pathNewFile) {
		
		for(int i = 0; i < listesNewDates.size(); ++i) {
			System.out.println("Date : " + listesNewDates.get(i).toString() + " //timestamp : " + listesNewDates.get(i));
		}
		
		modele.createNewXML(listesNewDates, pathNewFile);
	}
	
	
}
