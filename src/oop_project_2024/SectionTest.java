package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class SectionTest {

	    @Test
	    void addDoctorTestTrue() {
	        Section s = new Section(21, "Heart");
	        Doctor d1 = new Doctor("Sara", 987654321, 123456789);
	        Doctor d2 = new Doctor("Ahmet", 123456789, 987654321);
	        Doctor d3 = new Doctor("Lala", 555555555, 111111111);

	        s.addDoctor(d1);
	        s.addDoctor(d2);
	        s.addDoctor(d3);

	        assertEquals(d1, s.getDoctor(123456789));
	        assertEquals(d2, s.getDoctor(987654321));
	        assertEquals(d3, s.getDoctor(111111111));
	    }

	    @Test
	    void addDoctorTestFalse() {
	    	Section s = new Section(21, "Heart");
	        Doctor d1 = new Doctor("Sara", 987654321, 123456789);
	        Doctor d2 = new Doctor("Ahmet", 123456789, 987654321);
	        Doctor d3 = new Doctor("Lala", 555555555, 987654321);
	        
	        s.addDoctor(d1);
	        assertEquals(d1, s.getDoctor(123456789));

	        s.addDoctor(d2);
	        assertEquals(d2, s.getDoctor(987654321));

	        assertThrows(DuplicateInfoException.class, new Executable() {
	            public void execute() throws Throwable {
	                s.addDoctor(d3);
	            }
	        });
	    }
	    

	    @Test
	    void getDoctorTestFalse() {
	        Section s = new Section(21, "Heart");
	        Doctor d1 = new Doctor("Sara", 987654321, 123456789);
	        Doctor d2 = new Doctor("Ahmet", 123456789, 987654321);

	        s.addDoctor(d1);
	        s.addDoctor(d2);

	        assertEquals(d1, s.getDoctor(123456789));
	        assertEquals(d2, s.getDoctor(987654321));

	        assertNull(s.getDoctor(111111111));
	    }
	}
