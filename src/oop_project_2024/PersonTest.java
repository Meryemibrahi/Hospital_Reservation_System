package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testConstructor1() {
		String name = "Ahmed";
		long nationalId = 123456789;
        
        Person person = new Person(name, nationalId);
        assertEquals(name, person.getName());
        assertEquals(nationalId, person.getNational_id());
	}
	
	@Test
	void testConstructor2() {
		String name = "Sara";
		long nationalId = 987654321;
        
		Person person = new Person(name, nationalId);
        assertEquals(name, person.getName());
        assertEquals(nationalId, person.getNational_id());
        
	}

}
