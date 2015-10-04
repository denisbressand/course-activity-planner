package gui;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Utils.DateLabelFormatter;
import Utils.LireFichier;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Gui extends JFrame {

	JButton btnFileChooser; 
	JTextField status = new JTextField("Pas de fichier chargé!");
	JLabel lblDateStart, lblDateStop;
	GridLayout gridLayout = new GridLayout(4,2);
	UtilDateModel modelOpen, modelClose;
	JDatePickerImpl datePickerOpen, datePickerClose;
	JSpinner timeSpinnerOpen, timeSpinnerClose;
	
	

	public Gui() {

		super("titre de l'application");

		btnFileChooser = new JButton("Charger fichier XML");
		lblDateStart = new JLabel();
		lblDateStop = new JLabel();
		timeSpinnerOpen = new JSpinner( new SpinnerDateModel() );
		
		modelOpen = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanelOpen = new JDatePanelImpl(modelOpen, p);
		datePickerOpen = new JDatePickerImpl(datePanelOpen, new DateLabelFormatter());
		
		modelClose = new UtilDateModel();
		JDatePanelImpl datePanelClose = new JDatePanelImpl(modelClose, p);
		datePickerClose = new JDatePickerImpl(datePanelClose, new DateLabelFormatter());
		
		JSpinner.DateEditor timeEditorOpen = new JSpinner.DateEditor(timeSpinnerOpen, "HH:mm:ss");
		timeSpinnerOpen.setEditor(timeEditorOpen);
		timeSpinnerOpen.setValue(new Date());
		
		timeSpinnerClose = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditorClose = new JSpinner.DateEditor(timeSpinnerClose, "HH:mm:ss");
		timeSpinnerClose.setEditor(timeEditorClose);
		timeSpinnerClose.setValue(new Date());
		
		this.setTitle("ActivitETS");
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


		JPanel panneau = new JPanel();
		panneau.setLayout(gridLayout);
		panneau.add(btnFileChooser);
		panneau.add(status);
		panneau.add(datePickerOpen);
		panneau.add(datePickerClose);
		panneau.add(lblDateStart);
		panneau.add(lblDateStop);
		panneau.add(timeSpinnerOpen);
		panneau.add(timeSpinnerClose);
		
		this.setContentPane(panneau);

	}

	public String choixFic() {
		JFileChooser chooser = new JFileChooser(
				new File(
						"D:\\TravailCours\\ETS\\PFE\\QuizzMoodle\\activities\\quiz_65578"));// création
																							// dun
																							// nouveau
																							// filechosser
		chooser.setApproveButtonText("Choix du fichier..."); // intitulé du
																// bouton
		chooser.showOpenDialog(null); // affiche la boite de dialogue
		String path = "";
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();

		}
		status.setText(path);
		return path;
	}

	public JButton getButton() {
		return btnFileChooser;
	}

	public void afficherDates(ArrayList<Calendar> dates) {

		//dates.get(0).getD
		
		int yearOpen = datePickerOpen.getModel().getYear();
		int monthOpen = datePickerOpen.getModel().getMonth();
		int dayOpen = datePickerOpen.getModel().getDay();
		
		int yearClose = datePickerOpen.getModel().getYear();
		int monthClose = datePickerOpen.getModel().getMonth();
		int dayClose = datePickerOpen.getModel().getDay();

		
		modelOpen.setDate(yearOpen, monthOpen, dayOpen);
		modelClose.setDate(yearClose, monthClose, dayClose);
		modelOpen.setSelected(true);
		modelClose.setSelected(true);
		
		lblDateStart.setText(dates.get(0).getTime().toString());
		lblDateStop.setText(dates.get(1).getTime().toString());

	}

}