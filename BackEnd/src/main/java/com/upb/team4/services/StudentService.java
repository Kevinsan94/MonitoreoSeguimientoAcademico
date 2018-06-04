package com.upb.team4.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.beans.Student;
import com.upb.team4.utils.DBUtils;


@Path("/student")
public class StudentService {

	@POST
	@Path("/post")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response createStudent(Student s) {
		try {
				DBUtils.crearAlumno(s.getName(), s.getLastname(), s.getNumber(), s.getEmail(), s.getPassword());
				return Response.ok("Correctly created").build();

		} catch (ClassNotFoundException e) {
			return Response.ok("Error").build();
		}
	}

	@PUT
	@Path("/put")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response updateStudent(Student s){
		try{
			DBUtils.modificarAlumno(s);
			return Response.ok("Correctly updated").build();
		}catch (ClassNotFoundException e){
			return Response.ok("Error").build();
		}
	}

	@DELETE
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteStudent(Student s){
		try{
			DBUtils.eliminarAlumno(s.getCode());
			return Response.ok("Correctly deleted").build();
		}catch (ClassNotFoundException e){
			return Response.ok("Error").build();
		}
	}


}
