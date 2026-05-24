package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DuplicateInfoExceptionTest {

	@Test
	void testmessage1() {
		DuplicateInfoException e = new DuplicateInfoException("Testing Duplicate Method");
		assertEquals("Testing Duplicate Method", e.getMessage());
	}
	
	
	
	@Test
	void testmessage2() {
		DuplicateInfoException e = new DuplicateInfoException("1233456 Error");
		assertEquals("1233456 Error", e.getMessage());
	}
	
	@Test
    void Excptionisthrown() {
		Section Section = new Section(0, "Heart");
        Doctor doctor1 = new Doctor("Sara", 987654321, 123456789);
        Section.addDoctor(doctor1);

        Doctor doctor2 = new Doctor("Ahmed", 987654321, 987654321);

        assertThrows(DuplicateInfoException.class, new Executable() {
            public void execute() throws Throwable {
                Section.addDoctor(doctor2);
            }
        });
    }
}
