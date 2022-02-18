package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subject_name;
	@ManyToMany(targetEntity = ClassRoom.class, cascade = { CascadeType.ALL })  
	@JoinTable(name = "subject_classroom",   
	            joinColumns = { @JoinColumn(name = "subject_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "class_id") })  
	private List<ClassRoom> classrooms;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public List<ClassRoom> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(List<ClassRoom> classrooms) {
		this.classrooms = classrooms;
	}	
}
