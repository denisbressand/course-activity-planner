package modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Activites.Quiz;
import Utils.LireFichier;

public class Modele {

	private long dateStart, dateStop;
	public Quiz quiz = new Quiz();
	
	public ArrayList<Calendar> recupererDates(String path) {
		
		ArrayList<Calendar> listeDates = new ArrayList<Calendar>();
		
		LireFichier lireFic = new LireFichier();
		lireFic.lireFic(path);
		
		dateStart = lireFic.getDateStart();
		dateStop = lireFic.getDateStop();
		
		quiz.setDateStart(dateStart);
		quiz.setDateStop(dateStop);
		
		listeDates.add(quiz.getDateStart());
		listeDates.add(quiz.getDateStop());
		
		return listeDates;
	}
	
	
	
}
