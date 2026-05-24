package oop_project_2024;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int maxPatientPerDay;
	private LinkedList<Rendezous> session;
	private Doctor doctor;
	
	public Schedule(int maxPatientPerDay) {
		this.maxPatientPerDay = maxPatientPerDay;
		session = new LinkedList<>();
	}

	public int getMaxPatientPerDay() {
		return maxPatientPerDay;
	}

	public void setMaxPatientPerDay(int maxPatientPerDay) {
		this.maxPatientPerDay = maxPatientPerDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean addRendezous(Patient p, Date desired) {
		int count = 0;
		Calendar appointmentDate = Calendar.getInstance();
		appointmentDate.setTime(desired);
		
		for(Rendezous tmpsession: session) {
			Calendar dayCheck = Calendar.getInstance();
			dayCheck.setTime(tmpsession.getDateTime());
			
			if( appointmentDate.get(Calendar.YEAR) == dayCheck.get(Calendar.YEAR) &&
					appointmentDate.get(Calendar.DAY_OF_YEAR) == dayCheck.get(Calendar.DAY_OF_YEAR) )
					count++;
					}
					if( count < maxPatientPerDay ) {
					session.add(new Rendezous(p, doctor, desired));
					return true;
					}
					return false;
					}
	}
