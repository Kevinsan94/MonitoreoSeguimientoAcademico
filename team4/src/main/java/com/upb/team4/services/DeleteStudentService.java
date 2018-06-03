package com.upb.team4.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.utils.DBUtils;

@Path("/delete")
public class DeleteStudentService {
	
	@DELETE
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteStudent(String code) {
		
		try {
			
			DBUtils.eliminarAlumno(code);
			return Response.ok("Correctly deleted with code: "+code).build();
			
		} catch (ClassNotFoundException e) {
			return Response.ok("Ocurrio un error").build();
		}
		
	}
	
	
}
