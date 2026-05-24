package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import org.junit.jupiter.api.Test;

class ScheduleTest {
	
	@Test
	void testConstructor1() {
		Schedule schedule = new Schedule(3);
        assertEquals(3, schedule.getMaxPatientPerDay()); 
	}
	
	@Test
	void testConstructor2() {
		Schedule schedule = new Schedule(3000);
        assertEquals(3000, schedule.getMaxPatientPerDay()); 
	}
	
	@Test
	void addAppTestTrue() {
		
		Schedule doctorSchedule = new Schedule(1);
        Doctor doctor = new Doctor("Dr.Yasmin", 12345, 0);
        doctor.setSchedule(doctorSchedule);
        Patient patient = new Patient("Ahmet Mehmet", 123456789, 34675869);
        
        Calendar desiredDate = Calendar.getInstance();
        desiredDate.set(2025, Calendar.JANUARY, 20, 10, 30);
        
        boolean added = doctor.getSchedule().addRendezous(patient, desiredDate.getTime());
        assertTrue(added); 
	}
	
	
	@Test
	void addAppTestFalse() {
		
		Schedule doctorSchedule = new Schedule(0);
        Doctor doctor = new Doctor("Dr.Sara", 5314, 5314);
        doctor.setSchedule(doctorSchedule);
        Patient patient = new Patient("Elif Mehmet", 645, 16345);
        
        Calendar desiredDate = Calendar.getInstance();
        desiredDate.set(2025, Calendar.MARCH, 25, 14, 30);
        
        boolean added = doctor.getSchedule().addRendezous(patient, desiredDate.getTime());
        assertFalse(added); 
	}
}
