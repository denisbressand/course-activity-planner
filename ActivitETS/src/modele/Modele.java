package modele;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Activites.Quiz;
import Utils.OperationsFichiers;

public class Modele {

	private LocalDateTime dateStart, dateStop;
	private String quizName, quizResume;
	public Quiz quiz = new Quiz();
	OperationsFichiers operationsFics = new OperationsFichiers();
	
	public ArrayList<LocalDateTime> recupererDates(String path) {
		
		ArrayList<LocalDateTime> listeDates = new ArrayList<LocalDateTime>();
		
		
		operationsFics.lireFic(path);
		
		dateStart = operationsFics.getDateOpen();
		dateStop = operationsFics.getDateClose();

		
		quiz.setDateStart(dateStart);
		quiz.setDateStop(dateStop);
		
		System.out.println(quiz.getDateStart().toString());
		
		listeDates.add(quiz.getDateStart());
		listeDates.add(quiz.getDateStop());
		
		return listeDates;
	}
	
	public Quiz recupererInfos() {
		
		quizName = operationsFics.getQuizName();
		quizResume = operationsFics.getQuizResume();
		
		quiz.setNom(quizName);
		quiz.setResume(quizResume);
		
		return quiz;
	}
	
	public void createNewXML(ArrayList<LocalDateTime> listesNewDates, String pathNewFile) {
		
		operationsFics.ecrireFichier(listesNewDates, pathNewFile);
	}
	
}
