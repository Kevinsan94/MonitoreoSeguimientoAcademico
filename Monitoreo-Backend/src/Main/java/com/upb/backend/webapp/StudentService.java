package com.upb.backend.webapp;

import com.upb.backend.entity.Student;
import com.upb.backend.entity.User;
import com.upb.backend.webapp.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
public class StudentService {

    Database db = new Database();

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response createStudent(Student s) {

        db.createStudent(s);
        return Response.ok("Correctly created").build();
    }

    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response updateStudent(Student s) {

        db.updateStudent(s.getCode(), s.getName(), s.getLastname(), s.getNumber(), s.getEmail(), s.getPassword());
        return Response.ok("Correctly updated").build();
    }


    @DELETE
    @Path("/delete")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response deleteStudent(User u) {
        int code = u.getUsername();
        db.deleteStudent(code);
        return Response.ok("Correctly deleted").build();
    }
}