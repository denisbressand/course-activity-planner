package Activites;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Quiz {

	
	private int id;
	private String nom;
	private String resume;
	private Calendar dateStart = Calendar.getInstance();
	private Calendar dateStop = Calendar.getInstance();
	
	public Quiz(int id, String nom, String resume, Calendar dateStart, Calendar dateStop) {
		id =id;
		nom = nom;
		resume = resume;
		dateStart = dateStart;
		dateStop = dateStop;
	}
	
	public Quiz() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Calendar getDateStart() {
		return dateStart;
	}

	public void setDateStart(long date) {
		
	    dateStart.setTimeInMillis(date * 1000);
		
	}

	public Calendar getDateStop() {
		return dateStop;
	}

	public void setDateStop(long date) {
		
		dateStop.setTimeInMillis(date * 1000);
		
		
	}
	
	public String toString() {
		
		return "id : " + id + " //name : " + nom + " //resume : " + resume + " //dateStart : " + dateStart + " //dateStop : " + dateStop;
	}
	
	
}
