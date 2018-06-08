package com.upb.backend.webapp;

import com.upb.backend.entity.Notes;
import com.upb.backend.webapp.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/notas")
public class NotesService {

    Database db = new Database();

    @POST
    @Path("/insert")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response insertNotes(Notes n){
        try {
            db.insertNotes(n.getId(),n.getP1(),n.getP2(),n.getP3());
            return Response.ok("Correctly inserted").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


}