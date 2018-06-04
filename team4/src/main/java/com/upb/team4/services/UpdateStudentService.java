package com.upb.team4.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upb.team4.beans.Usuario;
import com.upb.team4.utils.AuthUtils;
import com.upb.team4.utils.DBUtils;

@Path("/update")
public class UpdateStudentService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response validaUsuario(Usuario u) {
        return Response.ok(response).build();
    }

    @GET
    public Response test(){
        return Response.ok("OKEY").build();
    }
}