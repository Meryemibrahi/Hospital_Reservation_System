package oop_project_2024;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CRS{
	private HashMap<Long, Patient> patients  = new HashMap<>();
	private LinkedList<Rendezous> rendezous = new LinkedList<>();
	private HashMap<Integer, Hospital> hospitals  = new HashMap<>();
	
	public HashMap<Long, Patient> getPatients() {
		return patients;
	}

	public LinkedList<Rendezous> getRendezous() {
		return rendezous;
	}

	public HashMap<Integer, Hospital> getHospitals() {
		return hospitals;
	}
	
	public Hospital getHospitals(int id) {
		for(Hospital tmpHospital: hospitals.values()) {
			if(tmpHospital.getId() == id) {
				return tmpHospital;
			}
		}
		return null;
	}


	public boolean makeRandezvous(long patientID, int hospitalID, int sectionID, int diplomaID, Date desiredDate) {
		Patient patient = patients.get(patientID);
		if( patient == null )
		throw new IDException("Patient ID not found" );
		Hospital hospital = hospitals.get(hospitalID);
		if( hospital == null )
		throw new IDException("Hospital ID not found");
		Section section = hospital.getSection(sectionID);
		if( section == null )
		throw new IDException("Section ID not found" );
		Doctor doctor = section.getDoctor(diplomaID);
		if( doctor == null )
		throw new IDException("Doctor ID not found");
		
		Schedule schedule = doctor.getSchedule();
		if( schedule == null ) {
		System.out.println("The doctor is not avalible yet, Please try again later");
		return false;
		}
		
		boolean AppointmentMade = schedule.addRendezous(patient, desiredDate);
		if( AppointmentMade ) {
		Rendezous newAppointent = new Rendezous(patient, doctor, desiredDate);
		rendezous.add(newAppointent);
		}
		return AppointmentMade;
	}
	

	public void addPatient(Patient patient) {
		for(Patient tmpPat: patients.values()) {
			if(tmpPat.getNational_id() == patient.getNational_id()) {
				throw  new DuplicateInfoException("Patient already recorded");
			}
		}
		synchronized (patients) {
	        patients.put(patient.getNational_id(), patient);
	    }
	}

	public void addHospital(Hospital hospital) {
		for(Hospital tmpHos: hospitals.values()) {
			if(tmpHos.getId() == hospital.getId()) {
				throw  new DuplicateInfoException("Hospital already exists");
			}
		}
		hospitals.put(hospital.getId(), hospital);
	}
    
    
	
    
    public void saveTablesToDisk( String fullPath ) {
    	
    	try {
    	
    	ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fullPath));
    	write.writeObject(patients);	
    	write.writeObject(rendezous);
    	write.writeObject(hospitals);
    	write.close();
    }catch(IOException e) {
    	System.out.println("Problem in saving data");
    }	
    }
    
    @SuppressWarnings("unchecked")
	public void loadTablesToDisk( String fullPath ) {
    	
    	try {
    		ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fullPath));
    		
    		patients = (HashMap<Long, Patient>)reader.readObject();
    		rendezous = (LinkedList<Rendezous>)reader.readObject();
    		hospitals = (HashMap<Integer, Hospital>)reader.readObject();
    		
    		reader.close();
    		
    	}catch(Exception e){
    		System.out.println("Problem in loading data to system");
    	}
    	
    }
    
}

