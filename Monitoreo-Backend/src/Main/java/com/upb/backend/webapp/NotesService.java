package com.upb.backend.webapp;

import com.upb.backend.entity.Notes;
import com.upb.backend.entity.Student;
import com.upb.backend.webapp.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notas")
public class NotesService {

   private Database db = new Database();

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getNotes(@QueryParam("id") int id){
        List<Notes> notes = db.getNotes(id);
        if (notes != null){
            return Response.ok().entity(notes).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/insert")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response insertNotes(Notes n){
        try {
            db.insertNotes(n.getStudent_id(), n.getMateria(), n.getP1(), n.getP2(), n.getP3());
            return Response.ok("Correctly inserted").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public static void main(String[] args){

    }
}