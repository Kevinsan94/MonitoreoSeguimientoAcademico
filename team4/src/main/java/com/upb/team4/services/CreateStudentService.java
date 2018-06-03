package com.upb.team4.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.beans.Student;
import com.upb.team4.utils.AuthUtils;
import com.upb.team4.utils.DBUtils;


@Path("/createStudent")
public class CreateStudentService {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response createStudent(Student s) {
		
		try {
				DBUtils.crearAlumno(s.getName(), s.getLastname(), s.getNumber(), s.getEmail(), s.getPassword());
				return Response.ok("Correctly created").build();
			
		
		} catch (ClassNotFoundException e) {
				
			return Response.ok("Ocurrio un Error").build();
		}
	}
}
