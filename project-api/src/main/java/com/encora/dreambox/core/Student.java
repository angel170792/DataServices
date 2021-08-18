package com.encora.dreambox.core;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String age;
	@JsonProperty
	private String grade;

	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;

	public Student() {

	}

	public Student(String id, String name, String age, String grade, School school) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.school = school;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", grade=" + grade
				+ ", school=" + school + "]";
	}

}
