package com.upb.backend.webapp;

import com.upb.backend.entity.Student;
import com.upb.backend.entity.User;

import javax.ws.rs.*;
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
    public String createStudent(Student s) {

        db.createStudent(s);
        return "Correctly created";
    }

    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String updateStudent(Student s) {
        db.updateStudent(s.getCode(), s.getName(), s.getLastname(), s.getNumber(), s.getEmail(), s.getPassword());
        return "Correctly updated";
    }


    @DELETE
    @Path("/delete")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String deleteStudent(User u) {
        int code = Integer.parseInt(u.getUsername());
        db.deleteStudent(code);
        return "Correctly deleted";
    }

    public static void main(String[] args){
        Database db = new Database();
        Student stu = new Student();
        stu.setName("Juan");
        stu.setLastname("sdad");
        stu.setNumber(23324232);
        stu.setEmail("sdasdassd");
        stu.setPassword("hola");
        db.createStudent(stu);
    }
}