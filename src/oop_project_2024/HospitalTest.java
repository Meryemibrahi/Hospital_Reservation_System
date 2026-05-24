package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class HospitalTest {

	@Test
	void addsectionTestTrue() {
		Hospital  h = new Hospital(23, "Big Hospital");
		Section s1 = new Section(21, "Heart");
		Section s3 = new Section(25, "Lungs");
		Section s2 = new Section(65, "Brain");
		
		h.addSection(s1);
		h.addSection(s2);
		h.addSection(s3);
		
		assertEquals(s1, h.getSection(21));
		assertEquals(s3, h.getSection(25));
		assertEquals(s2, h.getSection(65));
	}
	
	
	@Test
	void addsectionTestFalse() {
		Hospital  h = new Hospital(23, "Big Hospital");
		Section s1 = new Section(21, "Heart");
		Section s3 = new Section(25, "Lungs");
		Section s2 = new Section(25, "Lungs");
		
		h.addSection(s1);
		assertEquals(s1, h.getSection(21));
		h.addSection(s2);
		assertEquals(s2, h.getSection(25));
		
		assertThrows(DuplicateInfoException.class, new Executable() {
            public void execute() throws Throwable {
            	h.addSection(s3);
            }
        });
	}
	
	
	@Test
	void getsectionTestFalse() {
		Hospital  h = new Hospital(23, "Big Hospital");
		Section s1 = new Section(21, "Heart");
		Section s3 = new Section(25, "Lungs");
		
		h.addSection(s1);
		assertEquals(s1, h.getSection(21));
		h.addSection(s3);
		assertEquals(s3, h.getSection(25));
		assertNull(h.getSection(65));
		
	}
	
}