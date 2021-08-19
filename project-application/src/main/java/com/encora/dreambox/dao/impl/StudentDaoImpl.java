package com.encora.dreambox.dao.impl;

import org.hibernate.SessionFactory;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.dao.StudentDao;

import io.dropwizard.hibernate.AbstractDAO;

public class StudentDaoImpl extends AbstractDAO<Student> implements StudentDao {

	public StudentDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Student findById(String id) {
		return (Student) currentSession().get(Student.class, id);
	}
}
