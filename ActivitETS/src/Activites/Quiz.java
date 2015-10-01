package Activites;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz {

	
	private int id;
	private String nom;
	private String resume;
	private Date dateStart, dateStop;
	
	public Quiz(int id, String nom, String resume, Date dateStart, Date dateStop) {
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

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(String date) {
		
		dateStart = new java.util.Date((long)Integer.parseInt(date)*1000);
		
	}

	public Date getDateStop() {
		return dateStop;
	}

	public void setDateStop(String date) {
		
		dateStop = new java.util.Date((long)Integer.parseInt(date)*1000);
	}
	
	public String toString() {
		
		return "id : " + id + " //name : " + nom + " //resume : " + resume + " //dateStart : " + dateStart + " //dateStop : " + dateStop;
	}
	
	
}
