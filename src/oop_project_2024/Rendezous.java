package oop_project_2024;

import java.io.Serializable;
import java.util.Date;

public class Rendezous implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Date dateTime;
	private Patient Patient;
	private Doctor Doctor;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rendezous(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Rendezous(Patient p, Doctor doctor, Date desired) {
		this.setPatient(p);
		this.setDoctor(doctor);
		this.dateTime = desired;
	}

	public Doctor getDoctor() {
		return Doctor;
	}

	public void setDoctor(Doctor doctor) {
		Doctor = doctor;
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	@Override
	public String toString() {
		return "Rendezous [dateTim e=" + dateTime + "\n" + Patient.toString() + "\n" + Doctor.toString() + "]";
	}
	
	
}
