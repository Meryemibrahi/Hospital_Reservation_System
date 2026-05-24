package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoctorTest {
	private Doctor doctor;
	
	@BeforeEach
	void setDoctor() {
	String name = "Sara";
	long nationalId = 987654321;
	int diplomaID = 123456789;
	doctor = new Doctor(name, nationalId, diplomaID);
	}
	
	@Test
	void testConstructor1() {
		String name = "Ahmed";
		long nationalId = 123456789;
        int diplomaID = 987654321;
        
        Doctor doctor2 = new Doctor(name, nationalId, diplomaID);
        assertEquals(name, doctor2.getName());
        assertEquals(nationalId, doctor2.getNational_id());
        assertEquals(diplomaID, doctor2.getDiploma_id());
        
	}
	
	@Test
	void testConstructor2() {
        assertEquals("Sara", doctor.getName());
        assertEquals(987654321, doctor.getNational_id());
        assertEquals(123456789, doctor.getDiploma_id());
        
	}
	
	@Test
	void testSchedule() {
        Schedule testSchedule = new Schedule(12);
        doctor.setSchedule(testSchedule);
        assertEquals(testSchedule, doctor.getSchedule());
	}
	
	
}
