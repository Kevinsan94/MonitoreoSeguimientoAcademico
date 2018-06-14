package com.upb.backend.webapp;

import com.upb.backend.entity.Student;
import com.upb.backend.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/student")
public class StudentService {

    private Database db = new Database();


    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllStudents(){
        List<Student> students = db.getAllStudents();
        if (students != null){
            return Response.ok().entity(students).build();
        }
        return Response.serverError().build();
    }


    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Student getStudent(@QueryParam("id") int id) {
        return db.getStudent(id);
    }

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
        int code = Integer.parseInt(u.getUsername());
        db.deleteStudent(code);
        return Response.ok("Correctly deleted").build();
    }

    public static void main(String[] args){
        Database db = new Database();
        List<Student> students = db.getAllStudents();
        GenericEntity<List<Student>> entity = new GenericEntity<List<Student>>(students) {};
    }
}