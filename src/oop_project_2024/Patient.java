package oop_project_2024;

public class Patient extends Person{

	private static final long serialVersionUID = 1L;
	private final long patient_id;


	public Patient(String name, long national_id, long patient_id) {
		super(name, national_id);
		this.patient_id = patient_id;
	}
	
	

	public long getPatient_id() {
		return patient_id;
	}

	@Override
	public String toString() {
		return "Patient [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	

}
