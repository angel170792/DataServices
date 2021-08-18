package com.encora.dreambox.core;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "School")
public class School {

	@Id
	@JsonProperty
	private String id;

	private String schoolName;

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("school")
	private List<Student> students;

	public School() {
		
	}
	
	public School(String id, String schoolName) {
		this.id = id;
		this.schoolName = schoolName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + ", students=" + students + "]";
	}

}
