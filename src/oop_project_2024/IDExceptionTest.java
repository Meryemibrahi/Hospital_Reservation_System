package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class IDExceptionTest {


	@Test
	void testmessage1() {
		IDException e = new IDException("Testing Duplicate Method");
		assertEquals("Testing Duplicate Method", e.getMessage());
	}
	
	
	
	@Test
	void testmessage2() {
		IDException e = new IDException("1233456 Error");
		assertEquals("1233456 Error", e.getMessage());
	}
	
	@Test
    void Excptionisthrown() {
		
		Date date = new Date();
		CRS system = new CRS();

        assertThrows(IDException.class, new Executable() {
            public void execute() throws Throwable {
            	system.makeRandezvous(12L, 14, 15, 15, date);
            }
        });
    }

}
