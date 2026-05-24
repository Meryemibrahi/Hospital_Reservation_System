package oop_project_2024;

import java.io.Serializable;
import java.util.LinkedList;

public class Hospital implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final int id;
	private String name;
	private LinkedList<Section> sections;
	
	public Hospital(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		sections = new LinkedList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Section> getSections() {
		return sections;
	}

	public void setSections(LinkedList<Section> sections) {
		this.sections = sections;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}
	
	public Section getSection(int id) {
		for(Section tmpSection: sections) {
			if(tmpSection.getId() == id) {
				return tmpSection;
			}
		}
		return null;
	}
	
	private Section getSection(String name) {
		for(Section tmpSection: sections) {
			if(tmpSection.getName() == name) {
				return tmpSection;
			}
		}
		return null;
	}
	
	public void addSection(Section section) {
		if(getSection(section.getName()) != null) {
			throw new DuplicateInfoException("Section already exists");
		}
		sections.add(section);
	}
	
	
}
