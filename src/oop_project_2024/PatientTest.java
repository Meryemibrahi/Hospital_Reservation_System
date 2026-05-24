package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientTest {
	
	@Test
	void testConstructor1() {
		String name = "Ahmed";
		long nationalId = 123456789;
        long patientId = 987654321;
        
        Patient patient = new Patient(name, nationalId, patientId);
        assertEquals(patientId, patient.getPatient_id());
        
	}
	
	@Test
	void testConstructor2() {
		String name = "Sara";
		long nationalId = 987654321;
        long patientId = 675849321;
        
        Patient patient = new Patient(name, nationalId, patientId);
        assertEquals(patientId, patient.getPatient_id());
        
	}

}
