package com.encora.dreambox.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.encora.dreambox.core.School;
import com.encora.dreambox.dao.SchoolDao;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/dsapi/school")
@Produces(MediaType.APPLICATION_JSON)
public class SchoolResource {
	
	private SchoolDao schoolDao;
	
	public SchoolResource(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
	
	@GET
	@Path("/{id}")
	@UnitOfWork
	public School findSchoolById(@PathParam("id") String id) {
		return schoolDao.findById(id);
	}

}
