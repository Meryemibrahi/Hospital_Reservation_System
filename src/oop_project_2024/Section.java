package oop_project_2024;

import java.io.Serializable;
import java.util.LinkedList;

public class Section implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final int id;
	private String name;
	private LinkedList<Doctor> doctors;
	
	
	public Section(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		 doctors = new LinkedList<>();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LinkedList<Doctor> getDoctors() {
		return doctors;
	}


	public void setDoctors(LinkedList<Doctor> doctors) {
		this.doctors = doctors;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public Doctor getDoctor(int diploma_id) {
		for(Doctor tmpDoc: doctors) {
			if(tmpDoc.getDiploma_id() == diploma_id) {
        		return tmpDoc;
		}}
		return null;
	}
	
	public void addDoctor(Doctor doctor) {
		for(Doctor tmpDoc: doctors) {
			if(tmpDoc.getDiploma_id() == doctor.getDiploma_id()) {
				throw  new DuplicateInfoException("Doctor already exists");
			}
		}
		doctors.add(doctor);
	}
	
	/*if (getDoctor(doctor.getDiploma_id()) != null)*/
	
	
	
	
}


