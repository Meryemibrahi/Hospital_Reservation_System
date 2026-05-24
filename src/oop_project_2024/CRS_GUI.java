package oop_project_2024;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CRS_GUI {

	private CRS crs;
	CRS_GUI() {
        crs = new CRS();
        crs.loadTablesToDisk("SavedInfo");
        mainMenu();
	}
	
private void mainMenu() {
	    JFrame CRS = new JFrame();
        CRS.setSize(800, 700);
        CRS.setTitle("CRS - NYP Project");
        CRS.setResizable(true);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        CRS.setIconImage(logo.getImage());

        CRS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 800, 200);

        Image LogoImage = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon LogoIcon = new ImageIcon(LogoImage);

        JLabel LogoLabel = new JLabel();
        LogoLabel.setText("Clinical Reservation System");
        LogoLabel.setFont(new Font("MV Boli", Font.PLAIN, 50));
        LogoLabel.setIcon(LogoIcon);
        LogoLabel.setHorizontalTextPosition(JLabel.CENTER);  
        LogoLabel.setVerticalTextPosition(JLabel.BOTTOM);
        
        CRS.setLayout(null);
        CRS.add(titlePanel);

        JPanel doctorPanel = new JPanel();
        doctorPanel.setBounds(100, 250, 150, 150);

        JPanel hospitalPanel = new JPanel();
        hospitalPanel.setBounds(250, 250, 150, 150);

        JPanel sectionPanel = new JPanel();
        sectionPanel.setBounds(400, 250, 150, 150);

        JPanel patientPanel = new JPanel();
        patientPanel.setBounds(550, 250, 150, 150);

        JPanel savePanel = new JPanel();
        savePanel.setBounds(400, 450, 150, 150);

        JPanel exitPanel = new JPanel();
        exitPanel.setBounds(550, 450, 150, 150);

        JPanel appPanel = new JPanel();
        appPanel.setBounds(100, 450, 150, 150);

        JPanel viewPanel = new JPanel();
        viewPanel.setBounds(250, 450, 150, 150);

        ImageIcon doctorim = new ImageIcon("Doctor.png");
        ImageIcon hospitalim = new ImageIcon("Hospital.png");
        ImageIcon exitim = new ImageIcon("Exit.png");
        ImageIcon saveim = new ImageIcon("SaveFile.png");
        ImageIcon appim = new ImageIcon("App.png");
        ImageIcon paitentim = new ImageIcon("Paitent.png");
        ImageIcon veiwim = new ImageIcon("VeiwWork.png");
        ImageIcon sectionim = new ImageIcon("Section.png");
        
        Image doctorImage = doctorim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon doctorIcon = new ImageIcon(doctorImage);

        Image hospitalImage = hospitalim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon hospitalIconResized = new ImageIcon(hospitalImage);

        Image exitImage = exitim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon exitIconResized = new ImageIcon(exitImage);

        Image saveImage = saveim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon saveIconResized = new ImageIcon(saveImage);

        Image appImage = appim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon appIconResized = new ImageIcon(appImage);

        Image patientImage = paitentim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon patientIconResized = new ImageIcon(patientImage);

        Image viewImage = veiwim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon viewIconResized = new ImageIcon(viewImage);

        Image sectionImage = sectionim.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon sectionIconResized = new ImageIcon(sectionImage);

        JButton doctorButton = new JButton("Add Doctor", doctorIcon);
        doctorButton.setHorizontalTextPosition(JButton.CENTER);
        doctorButton.setVerticalTextPosition(JButton.BOTTOM);
        doctorButton.addActionListener(e -> doctorWindow());

        JButton hospitalButton = new JButton("Add Hospital", hospitalIconResized);
        hospitalButton.setHorizontalTextPosition(JButton.CENTER);
        hospitalButton.setVerticalTextPosition(JButton.BOTTOM);
        hospitalButton.addActionListener(e -> hospitalWindow());

        JButton sectionButton = new JButton("Add Section", sectionIconResized);
        sectionButton.setHorizontalTextPosition(JButton.CENTER);
        sectionButton.setVerticalTextPosition(JButton.BOTTOM);
        sectionButton.addActionListener(e -> sectionWindow()); // Added action listener for Section

        JButton exitButton = new JButton("Exit", exitIconResized);
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setVerticalTextPosition(JButton.BOTTOM);
        exitButton.addActionListener(e -> exitApplication());

        JButton saveButton = new JButton("Save", saveIconResized);
        saveButton.setHorizontalTextPosition(JButton.CENTER);
        saveButton.setVerticalTextPosition(JButton.BOTTOM);
        saveButton.addActionListener(e -> saveData(CRS));

        JButton appButton = new JButton("Add A Reservation", appIconResized);
        appButton.setHorizontalTextPosition(JButton.CENTER);
        appButton.setVerticalTextPosition(JButton.BOTTOM);
        appButton.addActionListener(e -> addReservation());

        JButton patientButton = new JButton("Add Patient", patientIconResized);
        patientButton.setHorizontalTextPosition(JButton.CENTER);
        patientButton.setVerticalTextPosition(JButton.BOTTOM);
        patientButton.addActionListener(e -> addPatient());

        JButton viewButton = new JButton("View Information", viewIconResized);
        viewButton.setHorizontalTextPosition(JButton.CENTER);
        viewButton.setVerticalTextPosition(JButton.BOTTOM);
        viewButton.addActionListener(e -> viewInformation());
        
        titlePanel.add(LogoLabel);
        doctorPanel.add(doctorButton);
        hospitalPanel.add(hospitalButton);
        sectionPanel.add(sectionButton);  
        patientPanel.add(patientButton);
        savePanel.add(saveButton);
        exitPanel.add(exitButton);
        appPanel.add(appButton);
        viewPanel.add(viewButton);

        CRS.add(doctorPanel);
        CRS.add(hospitalPanel);
        CRS.add(sectionPanel); 
        CRS.add(patientPanel);
        CRS.add(savePanel);
        CRS.add(exitPanel);
        CRS.add(appPanel);
        CRS.add(viewPanel);

        CRS.setVisible(true);
    }

    private void sectionWindow() {
        JFrame sectionFrame = new JFrame();
        sectionFrame.setSize(400, 300);
        sectionFrame.setTitle("Section Window");
        sectionFrame.setResizable(false);
        sectionFrame.setLayout(null);
        
        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        sectionFrame.setIconImage(logo.getImage());

        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 10, 400, 100);
        JLabel text = new JLabel("Add Section ");
        textPanel.add(text);
        text.setFont(new Font("MV Boli", Font.PLAIN, 30));
        
        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 100, 400, 30);
        JLabel name = new JLabel("Section Name:");
        name.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nameField = new JTextField(15);
        namePanel.add(name);
        namePanel.add(nameField);
        
        JPanel IDPanel = new JPanel();
        IDPanel.setBounds(0, 160, 400, 30);
        JLabel id = new JLabel("Section ID:");
        id.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField IDField = new JTextField(15);
        IDPanel.add(id);
        IDPanel.add(IDField);
        
        JPanel hospitalIDPanel = new JPanel();
        hospitalIDPanel.setBounds(0, 130, 400, 30);
        JLabel hospitalId = new JLabel("Hospital ID:");
        hospitalId.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField hospitalIDField = new JTextField(15);
        hospitalIDPanel.add(hospitalId);
        hospitalIDPanel.add(hospitalIDField);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 200, 400, 50);
        JButton addButton = new JButton("Add Section");
        ButtonPanel.add(addButton);
        
        sectionFrame.add(ButtonPanel);
        sectionFrame.add(IDPanel);
        sectionFrame.add(namePanel);
        sectionFrame.add(textPanel);
        sectionFrame.add(hospitalIDPanel);
        
        
        
        sectionFrame.setVisible(true);
        
        addButton.addActionListener(e -> {
            String namesection = nameField.getText();
            int secid;
            int hospitalid;
            try {
                secid = Integer.parseInt(IDField.getText());
                hospitalid = Integer.parseInt(hospitalIDField.getText());
                
                Section sec = new Section(secid, namesection);
                Hospital hospitals = crs.getHospitals(hospitalid);
                hospitals.addSection(sec);
                
                JOptionPane.showMessageDialog(sectionFrame, "Section added successfully!");
                sectionFrame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(sectionFrame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IDException ex) {
            	JOptionPane.showMessageDialog(sectionFrame, "Hospital ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DuplicateInfoException ex) {
                JOptionPane.showMessageDialog(sectionFrame, "Section Already exists", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(sectionFrame, "Unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void viewInformation() {
        
    	JFrame hospitalDetailsFrame = new JFrame("Hospital Details");
        hospitalDetailsFrame.setSize(500, 400);
        hospitalDetailsFrame.setResizable(false);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        hospitalDetailsFrame.setIconImage(logo.getImage());

        JTextArea hospitalDetails = new JTextArea();
        hospitalDetails.setEditable(false);
        hospitalDetails.setFont(new Font("Arial", Font.PLAIN, 14));
        hospitalDetails.setLineWrap(true);
        hospitalDetails.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(hospitalDetails);
        scrollPane.setBounds(10, 10, 460, 300);
        hospitalDetailsFrame.add(scrollPane);

        
            Map<Integer, Hospital> tmpHospital = crs.getHospitals();

            if (tmpHospital.isEmpty()) {
                hospitalDetails.append("There is no information recorded in the system.\n");
            } else {
                for (Hospital hospital : tmpHospital.values()) {
                    hospitalDetails.append("Hospital Details:\n");
                    hospitalDetails.append("Name: " + hospital.getName() + "\n");
                    hospitalDetails.append("----------------------------------------\n");
                    for (Section section : hospital.getSections()) {
                        hospitalDetails.append("  Section: " + section.getName() + "\n");
                        for (Doctor doctor : section.getDoctors()) {
                            hospitalDetails.append("    Doctor: " + doctor.getName() + ", Diploma ID: " + doctor.getDiploma_id() + "\n");
                        }
                    }
                    hospitalDetails.append("\n\n");
                }}

        hospitalDetailsFrame.setLayout(null);
        hospitalDetailsFrame.setVisible(true);
    }

    private void addPatient() {
        JFrame addPatientFrame = new JFrame();
        addPatientFrame.setSize(400, 300);
        addPatientFrame.setTitle("Add Patient");
        addPatientFrame.setResizable(false);
        addPatientFrame.setLayout(null);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        addPatientFrame.setIconImage(logo.getImage());
                
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 10, 400, 100);

        JLabel Text = new JLabel("Add Patient ");
        textPanel.add(Text);
        Text.setFont(new Font("MV Boli", Font.PLAIN, 30));
        
        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 100, 400, 30);
        JLabel name = new JLabel("Patient Name:");
        name.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nameField = new JTextField(15);
        namePanel.add(name);
        namePanel.add(nameField);
        
        JPanel IDPanel = new JPanel();
        IDPanel.setBounds(0, 160, 400, 30);
        JLabel id = new JLabel("Patient ID:");
        id.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField IDField = new JTextField(15);
        IDPanel.add(id);
        IDPanel.add(IDField);
        
        JPanel nationalIDPanel = new JPanel();
        nationalIDPanel.setBounds(0, 130, 400, 30);
        JLabel nationalid = new JLabel("Patient National ID:");
        nationalid.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nationalIDField = new JTextField(15);
        nationalIDPanel.add(nationalid);
        nationalIDPanel.add(nationalIDField);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 200, 400, 50);
        JButton addButton = new JButton("Add Patient");
        ButtonPanel.add(addButton);
        
        addPatientFrame.add(ButtonPanel);
        addPatientFrame.add(IDPanel);
        addPatientFrame.add(namePanel);
        addPatientFrame.add(textPanel);
        addPatientFrame.add(nationalIDPanel);
        addPatientFrame.setVisible(true);
        
        addButton.addActionListener(e -> {
            String namePatient = nameField.getText();
            long idPatient;
            long nationalPatient;
            try {
            	idPatient = Long.parseLong (IDField.getText());
            	nationalPatient = Long.parseLong (nationalIDField.getText());
                crs.addPatient(new Patient(namePatient, nationalPatient, idPatient));
                JOptionPane.showMessageDialog(addPatientFrame, "Patient added successfully!");
                addPatientFrame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addPatientFrame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void addReservation() {
        JFrame addReservationFrame = new JFrame();
        addReservationFrame.setSize(400, 400);
        addReservationFrame.setTitle("Add Reservation");
        addReservationFrame.setResizable(false);
        addReservationFrame.setLayout(null);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        addReservationFrame.setIconImage(logo.getImage());
        
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 10, 400, 100);
        JLabel text = new JLabel("Add Reservation ");
        textPanel.add(text);
        text.setFont(new Font("MV Boli", Font.PLAIN, 30));

        JPanel patientIDPanel = new JPanel();
        patientIDPanel.setBounds(0, 100, 400, 30);
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField patientIDField = new JTextField(15);
        patientIDPanel.add(patientIDLabel);
        patientIDPanel.add(patientIDField);
        
        JPanel doctorIDPanel = new JPanel();
        doctorIDPanel.setBounds(0, 130, 400, 30);
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        doctorIDLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField doctorIDField = new JTextField(15);
        doctorIDPanel.add(doctorIDLabel);
        doctorIDPanel.add(doctorIDField);

        JPanel sectionIDPanel = new JPanel();
        sectionIDPanel.setBounds(0, 160, 400, 30);
        JLabel sectionIDLabel = new JLabel("Section ID:");
        sectionIDLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField sectionIDField = new JTextField(15);
        sectionIDPanel.add(sectionIDLabel);
        sectionIDPanel.add(sectionIDField);

        JPanel hospitalIDPanel = new JPanel();
        hospitalIDPanel.setBounds(0, 190, 400, 30);
        JLabel hospitalIDLabel = new JLabel("Hospital ID:");
        hospitalIDLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField hospitalIDField = new JTextField(15);
        hospitalIDPanel.add(hospitalIDLabel);
        hospitalIDPanel.add(hospitalIDField);
        
        JPanel datePanel = new JPanel();
        datePanel.setBounds(0, 220, 400, 30);
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField dateField = new JTextField(15);
        datePanel.add(dateLabel);
        datePanel.add(dateField);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 290, 400, 50);
        JButton addButton = new JButton("Add Reservation");
        ButtonPanel.add(addButton);
        
        addReservationFrame.add(ButtonPanel);
        addReservationFrame.add(datePanel);
        addReservationFrame.add(hospitalIDPanel);
        addReservationFrame.add(sectionIDPanel);
        addReservationFrame.add(doctorIDPanel);
        addReservationFrame.add(patientIDPanel);
        addReservationFrame.add(textPanel);
        
        addReservationFrame.setVisible(true);
        
        addButton.addActionListener(e -> {
            try {
            	long patientId = Long.parseLong(patientIDField.getText());
                int hospitalId = Integer.parseInt(hospitalIDField.getText());
                int sectionId = Integer.parseInt(sectionIDField.getText());
                int doctorId = Integer.parseInt(doctorIDField.getText());
                String dateString = dateField.getText();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                
                boolean success = crs.makeRandezvous(patientId, hospitalId, sectionId, doctorId, date);
                if (success) {
                    JOptionPane.showMessageDialog(addReservationFrame, "Appointment made successfully!");
                } else {
                    JOptionPane.showMessageDialog(addReservationFrame, "Failed to make appointment.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                addReservationFrame.dispose();
            }catch (IDException ex) {
                JOptionPane.showMessageDialog(addReservationFrame, "Hospital ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (DuplicateInfoException ex) {
                JOptionPane.showMessageDialog(addReservationFrame, "Doctor Already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(addReservationFrame, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
    }


    private void saveData(JFrame cRS2) {
        crs.saveTablesToDisk("SavedInfo");
        JOptionPane.showMessageDialog(cRS2, "Information saved successfully!");
    }

    private void exitApplication() {
        System.exit(0);
    }

    private void hospitalWindow() {
        JFrame hospitalFrame = new JFrame();
        hospitalFrame.setSize(400, 300);
        hospitalFrame.setTitle("Hospital Window");
        hospitalFrame.setResizable(false);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        hospitalFrame.setIconImage(logo.getImage());
        
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 10, 400, 100);

        JLabel Text = new JLabel("Add Hospital ");
        textPanel.add(Text);
        Text.setFont(new Font("MV Boli", Font.PLAIN, 30));
        
        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 100, 400, 30);
        JLabel name = new JLabel("Hospital Name:");
        name.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nameField = new JTextField(15);
        namePanel.add(name);
        namePanel.add(nameField);
        
        JPanel IDPanel = new JPanel();
        IDPanel.setBounds(0, 130, 400, 50);
        JLabel id = new JLabel("Hospital ID:");
        id.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField IDField = new JTextField(15);
        IDPanel.add(id);
        IDPanel.add(IDField);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 200, 400, 50);
        JButton addButton = new JButton("Add Hospital");
        ButtonPanel.add(addButton);
        
        hospitalFrame.add(ButtonPanel);
        hospitalFrame.add(IDPanel);
        hospitalFrame.add(namePanel);
        hospitalFrame.add(textPanel);
        hospitalFrame.setVisible(true);
        
        
        addButton.addActionListener(e -> {
            int idHospital;
            try {
            	idHospital = Integer.parseInt(IDField.getText());
                String nameHas = nameField.getText();
                crs.addHospital(new Hospital(idHospital, nameHas));
                JOptionPane.showMessageDialog(hospitalFrame, "Hospital added!");
                hospitalFrame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(hospitalFrame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (IDException ex) {
                JOptionPane.showMessageDialog(hospitalFrame, "Hospital ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (DuplicateInfoException ex) {
                JOptionPane.showMessageDialog(hospitalFrame, "Doctor Already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    private void doctorWindow() {
        JFrame doctorFrame = new JFrame();
        doctorFrame.setSize(400, 400);
        doctorFrame.setTitle("Doctor Window");
        doctorFrame.setResizable(false);
        doctorFrame.setLayout(null);

        ImageIcon logo = new ImageIcon("Yildiz_Technical_University_logo.svg-1024x1024-1854355890.png");
        doctorFrame.setIconImage(logo.getImage());
        
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 10, 400, 100);
        JLabel text = new JLabel("Add Doctor ");
        textPanel.add(text);
        text.setFont(new Font("MV Boli", Font.PLAIN, 30));
        
        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 100, 400, 30);
        JLabel name = new JLabel("Doctor Name:");
        name.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nameField = new JTextField(15);
        namePanel.add(name);
        namePanel.add(nameField);
        
        JPanel nationalIDPanel = new JPanel();
        nationalIDPanel.setBounds(0, 130, 400, 30);
        JLabel nationalId = new JLabel("National ID:");
        nationalId.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField nationalIDField = new JTextField(15);
        nationalIDPanel.add(nationalId);
        nationalIDPanel.add(nationalIDField);
        
        JPanel diplomaIDPanel = new JPanel();
        diplomaIDPanel.setBounds(0, 160, 400, 30);
        JLabel diplomaId = new JLabel("Diploma ID:");
        diplomaId.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField diplomaIDField = new JTextField(15);
        diplomaIDPanel.add(diplomaId);
        diplomaIDPanel.add(diplomaIDField);
        
        JPanel sectionIDPanel = new JPanel();
        sectionIDPanel.setBounds(0, 190, 400, 30);
        JLabel sectionId = new JLabel("Section ID:");
        sectionId.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField sectionIDField = new JTextField(15);
        sectionIDPanel.add(sectionId);
        sectionIDPanel.add(sectionIDField);
        
        JPanel hospitalIDPanel = new JPanel();
        hospitalIDPanel.setBounds(0, 220, 400, 30);
        JLabel hospitalId = new JLabel("Hospital ID:");
        hospitalId.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField hospitalIDField = new JTextField(15);
        hospitalIDPanel.add(hospitalId);
        hospitalIDPanel.add(hospitalIDField);
        
        
        JPanel dayIDPanel = new JPanel();
        dayIDPanel.setBounds(0, 250, 400, 30);
        JLabel maxday = new JLabel("Max Number Per Day:");
        dayIDPanel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        JTextField dayIDField = new JTextField(15);
        dayIDPanel.add(maxday);
        dayIDPanel.add(dayIDField);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 300, 400, 50);
        JButton addButton = new JButton("Add Doctor");
        ButtonPanel.add(addButton);
        
        doctorFrame.add(ButtonPanel);
        doctorFrame.add(hospitalIDPanel);
        doctorFrame.add(sectionIDPanel);
        doctorFrame.add(diplomaIDPanel);
        doctorFrame.add(nationalIDPanel);
        doctorFrame.add(namePanel);
        doctorFrame.add(textPanel);
        doctorFrame.add(dayIDPanel);
        
        doctorFrame.setVisible(true);
        
        addButton.addActionListener(e -> {
            String nameDoctor = nameField.getText();
            long docnationalId;
            int docdiplomaId;
            int secid;
            int hospitalid;
            int daynum;
            try {
            	docnationalId = Long.parseLong(nationalIDField.getText());
            	docdiplomaId = Integer.parseInt(diplomaIDField.getText());
            	secid = Integer.parseInt(sectionIDField.getText());
            	hospitalid = Integer.parseInt(hospitalIDField.getText());
            	daynum = Integer.parseInt(dayIDField.getText());
            	Doctor doctor = new Doctor(nameDoctor, docnationalId, docdiplomaId);
            	Schedule docsec = new Schedule(daynum);
            	doctor.setSchedule(docsec);
            	Hospital hospitals = crs.getHospitals(hospitalid);
            	Section sections = hospitals.getSection(secid);
            	sections.addDoctor(doctor);
            	
           
                JOptionPane.showMessageDialog(doctorFrame, "Doctor added successfully!");
                doctorFrame.dispose();
            }catch (IDException ex) {
                JOptionPane.showMessageDialog(doctorFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }catch (DuplicateInfoException ex) {
                JOptionPane.showMessageDialog(doctorFrame, "Doctor Already exists", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(doctorFrame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        addButton.addActionListener(e -> {
            String nameDoctor = nameField.getText();
            long docnationalId;
            int docdiplomaId;
            int secid;
            int hospitalid;
            try {
                System.out.println("Parsing input values...");
                docnationalId = Long.parseLong(nationalIDField.getText());
                docdiplomaId = Integer.parseInt(diplomaIDField.getText());
                secid = Integer.parseInt(sectionIDField.getText());
                hospitalid = Integer.parseInt(hospitalIDField.getText());
                
                System.out.println("Inputs parsed successfully.");
                
                Doctor doctor = new Doctor(nameDoctor, docnationalId, docdiplomaId);
                Hospital hospitals = crs.getHospitals(hospitalid);
                Section sections = hospitals.getSection(secid);
                sections.addDoctor(doctor);

                JOptionPane.showMessageDialog(doctorFrame, "Doctor added successfully!");
                doctorFrame.dispose();
            } catch (IDException ex) {
                JOptionPane.showMessageDialog(doctorFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DuplicateInfoException ex) {
                JOptionPane.showMessageDialog(doctorFrame, "Doctor Already exists", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(doctorFrame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(doctorFrame, "Unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
    }}
