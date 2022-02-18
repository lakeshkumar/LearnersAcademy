package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String class_name;
	
	@ManyToMany(targetEntity = Teacher.class, cascade = { CascadeType.ALL })  
	@JoinTable(name = "classroom_teacher",   
	            joinColumns = { @JoinColumn(name = "class_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "teacher_id") })  
	private List<Teacher> teachers;
	
	@OneToOne(targetEntity=Student.class)  
	private Student students;  
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Student getStudents() {
		return students;
	}
	public void setStudents(Student students) {
		this.students = students;
	}	
}
