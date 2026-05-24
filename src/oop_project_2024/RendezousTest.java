package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RendezousTest {

	Rendezous App;
	Date currentDate;
	Patient Patient;
	Doctor Doctor;
	
	
	@BeforeEach
	void setAppoientment() {
		Calendar calendar = Calendar.getInstance();
		currentDate = calendar.getTime();
		
		 Patient = new Patient("Ahmet", 1234, 13224);
		 Doctor = new Doctor("Dr.Elif", 1234, 87646);
	}
	
	@Test
	void testConstructor1() {
		Calendar calendar = Calendar.getInstance();
		Date desired = calendar.getTime();
		
		Patient Patient2 = new Patient("Selem", 757, 876);
		Doctor Doctor2 = new Doctor("Dr.Fatima", 765, 234);
		
		App = new Rendezous(Patient2, Doctor2, desired);
        
        assertEquals(Patient2, App.getPatient());
        assertEquals(Doctor2, App.getDoctor());
        assertEquals(desired, App.getDateTime());
        
	}
	
	@Test
	void testConstructor2() {
		
		App = new Rendezous(Patient, Doctor, currentDate);
		
		assertEquals(Patient, App.getPatient());
        assertEquals(Doctor, App.getDoctor());
        assertEquals(currentDate, App.getDateTime());
        
	}
}


