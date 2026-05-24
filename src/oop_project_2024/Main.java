package oop_project_2024;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] arg) {
	
		boolean useGui = true;
		if(useGui) {
			SwingUtilities.invokeLater(CRS_GUI::new);
		}else{
			
			CRS system = new CRS();
			System.out.println("******************************************************************************");
			System.out.println("                BLM2012 Nesneye Yönelik Programlama          ");
			System.out.println("               2024-2025 Güz Yarıyılı Semester Project       ");
			System.out.println("                Grup 3 - Dr. Öğretim Üyesi Furkan Çakmak           ");
			System.out.println("              23011942 - Mariam Sherif Abdelfattah Ibrahim            ");
			System.out.println("******************************************************************************");
		    	
			system.loadTablesToDisk("SavedInfo");
			
			System.out.println("                Welcome to the Clinic Reservation System          ");
			boolean exit = false;
			int Action = 0;
			
	        int hospitalID;
	        int sectionID;
	        int diplomaID;
	        int maxApp;
	        long nationalID;
	        long patientID;
	        Date desiredDate;
	        String patientName;
	        String doctorName;
	        String hospitalName;
	        String sectionName;
	        Hospital tmphospital;
	        Section tmpsection;
	        HashMap<Integer, Hospital> tmpHospital;
	        HashMap<Long, Patient> tmpPatients;
	        LinkedList<Rendezous> Appointemts;
			
			Scanner user = new Scanner(System.in);

			while(!exit) {
				
				System.out.print("\nPlease enter the number for the information you would like to handle:\nHostpital: \n1. Add Hospital \n");
				System.out.print("Section: \n2. Add Section \n");
				System.out.print("Doctor: \n3. Add Doctor \n");
				System.out.print("Patient: \n4. Add Patient \n5. List Patients \n6. Add Appiontement \n7.Veiw Appointements\n");
				System.out.print("Other: \n8. List all information \n9. Exit\nEnter Number: ");
				
				try {
					Action = user.nextInt();
				}catch(InputMismatchException e){
					System.out.print("Not A Number please Try again");
				}
				
				switch(Action) {
				case 1:
					try {
						System.out.print("Enter Name of Hospital: ");
						hospitalName = user.next();
						System.out.print("Enter Hospital ID: ");
						hospitalID = user.nextInt();
						Hospital hospital = new Hospital(hospitalID, hospitalName);
				        system.addHospital(hospital);
				
					}catch(InputMismatchException e){
						System.out.println("Please Enter the correct information");
					}catch(DuplicateInfoException e){
						e.getMessage();
					}
					
					break;
					
				case 8:
					tmpHospital = system.getHospitals();
					
					if(tmpHospital.isEmpty()) {
						System.out.println("There is no information recoreded to the system");
					}else {
					for(Hospital hospitals: tmpHospital.values()) {
					System.out.println("Hospital Details: ");
			        System.out.println("Name: " + hospitals.getName());
			        for (Section section : hospitals.getSections()) {
			            System.out.println("  Section: " + section.getName());
			            for (Doctor doctor : section.getDoctors()) {
			                System.out.println("    Doctor: " + doctor.getName() + ", Diploma ID: " + doctor.getDiploma_id());
			            }
			        }}}
					break;
				case 2:
					try {
						System.out.print("Enter Name of Section: ");
						sectionName = user.next();
						System.out.print("Enter Section ID: ");
						sectionID = user.nextInt();
						System.out.print("Enter Hospital ID: ");
						hospitalID = user.nextInt();
						Section section = new Section(sectionID, sectionName);
						tmphospital = system.getHospitals(hospitalID);
						if(tmphospital == null) {
							System.out.println("The hospital you entered was not found, the section could not be saved, please try again");
						}else {
							tmphospital.addSection(section);
						}
					}catch(InputMismatchException e){
						System.out.println("Please Enter the correct information");
					}catch(DuplicateInfoException e) {
						e.getMessage();
					}
					break;
				case 3:
					try {
						System.out.print("Enter Name of Doctor: ");
						doctorName = user.next();
						System.out.print("Enter national ID: ");
						nationalID = user.nextLong();
						System.out.print("Enter diploma ID: ");
						diplomaID = user.nextInt();
						System.out.print("Enter maximum number of patients per day: ");
						maxApp = user.nextInt();
						System.out.print("Enter section ID: ");
						sectionID = user.nextInt();
						System.out.print("Enter Hospital ID: ");
						hospitalID = user.nextInt();
		
				        
						Doctor doctor = new Doctor(doctorName, nationalID, diplomaID);
						Schedule schedule = new Schedule(maxApp); 
				        doctor.setSchedule(schedule);
				        
						tmphospital = system.getHospitals(hospitalID);
						if(tmphospital == null) {
							System.out.println("The hospital you entered was not found, the doctor could not be added, please try again");
						}else {
							tmpsection = tmphospital.getSection(sectionID);
							if(tmpsection == null) {
								System.out.println("The section you entered was not found, the doctor could not be added, please try again");
							}else {
								tmpsection.addDoctor(doctor);
							}
						}
						
						
					}catch(InputMismatchException e){
						System.out.println("Please Enter the correct information");
					}catch(DuplicateInfoException e) {
						e.getMessage();
					}			
					
					break;
				case 4:
					try {
						System.out.print("Enter Name of Patient: ");
						patientName = user.next();
						System.out.print("Enter national ID: ");
						nationalID = user.nextLong();
						System.out.print("Enter Patient ID: ");
						patientID = user.nextLong();
						
						Patient patient = new Patient(patientName, nationalID, patientID);
						system.addPatient(patient);
						
					}catch(InputMismatchException e){
						System.out.println("Please Enter the correct information");
					}catch(DuplicateInfoException e) {
						e.getMessage();
					}			
					
					break;
				case 5:
					tmpPatients = system.getPatients();
					
					if(tmpPatients == null) {
						System.out.println("There are no Patients recoreded to the system");
					}else {
					for(Patient patient: tmpPatients.values()) {
					System.out.println("Patient Information: ");
					patient.toString();
					}}
					break;
				case 6:
					try {
									
						System.out.print("Enter Patient ID: ");
						patientID = user.nextLong();
						System.out.print("Enter Doctor ID: ");
						diplomaID = user.nextInt();
						System.out.print("Enter section ID: ");
						sectionID = user.nextInt();
						System.out.print("Enter Hospital ID: ");
						hospitalID = user.nextInt();

						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				        dateFormat.setLenient(false);

				        System.out.println("Enter Desired Date in the format (dd-MM-yyyy):");
				        String input = user.nextLine();

				        desiredDate = dateFormat.parse(input);
						
				        boolean booked = system.makeRandezvous(patientID, hospitalID, sectionID, diplomaID, desiredDate);
				        if (booked) {
				            System.out.println("Appointment successfully scheduled");
				        } else {
				            System.out.println("Failed to schedule appointment");
				        }
						
					}catch(InputMismatchException e){
						System.out.println("Please Enter the correct information");
					}catch(IDException e) {
						e.getMessage();
					}catch (ParseException e) {
			            System.out.println("Invalid date format. Please enter the date as (dd-MM-yyyy).");
			        }	
					
					
					break;
				case 7:
					Appointemts = system.getRendezous();
					int i =0;
					
					if(Appointemts == null) {
						System.out.println("There are no appointemts recoreded to the system");
					}else {	
					for(Rendezous tmpApp: Appointemts) {
					System.out.println("\nAppointment " + i + " :");
					tmpApp.toString();
			        i++;
					}}
					
					break;
				case 9: 
					exit = true;
					break;
				
			}
			}
			
			system.saveTablesToDisk("SavedInfo");
			user.close();

			
		}
	
		

		
	}
	}
