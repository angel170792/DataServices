package com.encora.dreambox.client;

import com.encora.dreambox.core.School;
import com.encora.dreambox.core.Student;

public interface DataServicesClient {

	School findSchoolById(String id);

	Student findStudentById(String id);

}
