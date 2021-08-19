package com.encora.dreambox.dao.impl;

import org.hibernate.SessionFactory;

import com.encora.dreambox.core.School;
import com.encora.dreambox.dao.SchoolDao;

import io.dropwizard.hibernate.AbstractDAO;

public class SchoolDaoImpl extends AbstractDAO<School> implements SchoolDao {

	public SchoolDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public School findById(String id) {
		return (School) currentSession().get(School.class, id);
	}
}
