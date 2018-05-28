package com.upb.team4.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.beans.Student;
import com.upb.team4.utils.DBUtils;


@Path("/createStudent")
public class CreateStudentService {
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createStudent(Student s) {
		
		try {
			
			DBUtils.crearAlumno(s.getName(), s.getLastname(), s.getNumber(), s.getEmail(), s.getPassword());
			return Response.ok("Estudiante creado correctamente").build();
			
		} catch (ClassNotFoundException e) {
			
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		
		}
	}
}
