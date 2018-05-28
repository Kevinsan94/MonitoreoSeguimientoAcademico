package com.upb.team4.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.beans.Usuario;
import com.upb.team4.utils.DBUtils;

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
		if (username==null && password==null) {
			response = "You must enter user and pass";
		} else
			try {
				if (DBUtils.verificatedUser(username, password)){
					response = "Accepted";
				} else if (password.contains(username)) {
					response = "Password contains username, not accepted";
				} else if (password.length()<8) {
					response = "Password invalid";
				}
			} catch (ClassNotFoundException e) {
				response = "Ocurrio un error";
			} catch (NullPointerException es) {
				response = "Ocurrio un error";
			}
		return response;
	}
	
}