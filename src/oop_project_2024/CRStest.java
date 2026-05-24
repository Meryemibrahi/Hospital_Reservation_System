package oop_project_2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CRStest {
	
	
	@Test
	public void AppointmentFlase() {
		CRS systemCrs = new CRS();
		
		Map<Long, Patient> patients = new HashMap<>();
	    Map<Integer, Hospital> hospitals = new HashMap<>();
		
		Patient patient = new Patient("John Doe", 12345L, 1234L);
        patients.put(patient.getPatient_id(), patient);
        
        Hospital hospital = new Hospital(1, "City Hospital");
        hospitals.put(hospital.getId(), hospital);
        
        Section section = new Section(101, "Cardiology");
        hospital.addSection(section);

        Doctor doctor = new Doctor("Dr. Smith", 10101, 1273);
        section.addDoctor(doctor);
        
        Schedule schedule = new Schedule(43);
        doctor.setSchedule(schedule);

        Date desiredDate = new Date(1231/02/23);
        

        boolean appointmentMade = systemCrs.makeRandezvous(patient.getPatient_id(), hospital.getId(), section.getId(), doctor.getDiploma_id(), desiredDate);
        assertTrue(appointmentMade);
		
	}
	
	
	private Hospital hospital2;
    private Hospital hospital1;

  

    @Test
    public void testAddHospitalSuccessfully() {
    	CRS hospitalSystem = new CRS();
    	
    	hospitalSystem = new CRS();
        hospital1 = new Hospital(1, "City Hospital");
        hospital2 = new Hospital(1, "Metro Hospital");
        hospitalSystem.addHospital(hospital1);

        Hospital addedHospital = hospitalSystem.getHospitals(1);
        assertEquals(addedHospital, hospital1);
    }

}
