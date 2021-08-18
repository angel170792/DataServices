package com.encora.dreambox.dao;

import org.hibernate.SessionFactory;

import com.encora.dreambox.core.Student;

import io.dropwizard.hibernate.AbstractDAO;

public class StudentDao extends AbstractDAO<Student>{

	public StudentDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Student findById(String id) {
        return (Student) currentSession().get(Student.class, id);
    }
}
