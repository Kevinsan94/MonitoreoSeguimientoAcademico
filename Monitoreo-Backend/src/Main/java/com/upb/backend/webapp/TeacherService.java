package com.upb.backend.webapp;

import com.upb.backend.entity.Student;
import com.upb.backend.entity.Teacher;
import com.upb.backend.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/teacher")
public class TeacherService {

    private Database db = new Database();


    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllTeachers(){
        List<Teacher> teachers = db.getAllTeachers();
        if (teachers != null){
            return Response.ok().entity(teachers).build();
        }
        return Response.serverError().build();
    }

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Teacher getTeacher(@QueryParam("id") int id) {
        return db.getTeacher(id);
    }

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response createTeacher(Teacher t) {

        db.createTeacher(t);
        return Response.ok("Correctly created").build();
    }

    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response updateTeacher(Teacher s) {
        db.updateTeacher(s.getCode(), s.getName(), s.getLast_name(), s.getNumber(), s.getEmail(), s.getPassword());
        return Response.ok("Correctly updated").build();
    }


    @DELETE
    @Path("/delete")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response deleteTeacher(User u) {
        int code = Integer.parseInt(u.getUsername());
        db.deleteStudent(code);
        return Response.ok("Correctly deleted").build();
    }

}
