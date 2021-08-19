package com.encora.dreambox.client.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.JerseyClientBuilder;

import com.encora.dreambox.client.DataServicesClient;
import com.encora.dreambox.client.util.enums.DataServiceModulesEnum;
import com.encora.dreambox.core.School;
import com.encora.dreambox.core.Student;

public class DataServicesClientImpl implements DataServicesClient {

	private static final String URL = "http://localhost:8080/dsapi/%s/%s";

	private Client client;

	public DataServicesClientImpl() {
		this.client = new JerseyClientBuilder().build();
	}

	public School findSchoolById(String id) {
		return this.client.target(String.format(URL, DataServiceModulesEnum.SCHOOL.toString(), id))
				.request(MediaType.APPLICATION_JSON).get(School.class);
	}

	public Student findStudentById(String id) {
		return this.client.target(String.format(URL, DataServiceModulesEnum.STUDENT.toString(), id))
				.request(MediaType.APPLICATION_JSON).get(Student.class);
	}

}
