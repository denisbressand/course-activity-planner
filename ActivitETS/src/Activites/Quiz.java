package Activites;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Quiz {

	
	private int id;
	private String nom;
	private String resume;
	private LocalDateTime dateOpen;
	private LocalDateTime dateClose;
	TimeZone timeZone = TimeZone.getDefault();
	
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

	public LocalDateTime getDateStart() {
		return dateOpen;
	}

	public void setDateStart(LocalDateTime date) {
		
	    dateOpen = date;
		
	}

	public LocalDateTime getDateStop() {
		return dateClose;
	}

	public void setDateStop(LocalDateTime date) {
		dateClose = date;	
	}
	
	public String toString() {
		
		return "id : " + id + " //name : " + nom + " //resume : " + resume + " //dateStart : " + dateOpen + " //dateStop : " + dateClose;
	}
	
	
}
