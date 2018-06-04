package com.upb.team4.services;



import main.java.com.upb.team4.beans.Usuario;
import com.upb.team4.utils.AuthUtils;
import com.upb.team4.utils.DBUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginService {
	
	@POST
	@Path("/auth")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response validaUsuario(Usuario u) {
		
		String response = authenticate(u.getUsername(),u.getPassword());
		
		return Response.ok(response).build();
	}
	
	private String authenticate(String username, String password) {
		
		String response = "Not Accepted";
		try {
			
			if (!AuthUtils.verifiedCredentials(username, password)) {
				return "You must enter valid username and password";
			} 
			
			if(!AuthUtils.securedPassword(username, password)) {
				return "You must enter a secure password";
			}
			
			if (DBUtils.verificatedUser(username, password)){
				response = "Accepted";
			}
			
			
		} catch (ClassNotFoundException e) {
			response = "Error";
		}
		
		return response;
	}
}
