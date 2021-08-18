package com.encora.dreambox.dao;

import org.hibernate.SessionFactory;

import com.encora.dreambox.core.School;

import io.dropwizard.hibernate.AbstractDAO;

public class SchoolDao extends AbstractDAO<School> {

	public SchoolDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public School findById(String id) {
		return (School) currentSession().get(School.class, id);
	}
}
