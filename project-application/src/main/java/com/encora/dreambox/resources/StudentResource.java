package com.encora.dreambox.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.encora.dreambox.core.Student;
import com.encora.dreambox.dao.StudentDao;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/dsapi/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
	private StudentDao studentDao;

	public StudentResource(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@GET
	@Path("/{id}")
	@UnitOfWork
	public Student findStudentById(@PathParam("id") String id) {
		return studentDao.findById(id);
	}

}
