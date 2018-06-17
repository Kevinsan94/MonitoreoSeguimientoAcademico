package com.upb.backend.webapp;

import com.upb.backend.entity.User;
import com.upb.backend.utils.AuthUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginService {

    private Database db = new Database();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String login(User u){

        String response = "Not Accepted";
        String username = u.getUsername();
        String password = u.getPassword();

            if (!AuthUtils.verifiedCredentials(username, password)){
                response = "You must enter valid username and password";
                return response;
            }
            if (!AuthUtils.securedPassword(username, password)){
                response = "You must enter a secure password";
                return response;
            }
            if (db.verifiedAdmin(username, password)){
                response = "Accepted Admin";
                return response;
            }
            if (db.verifiedStudent(Integer.parseInt(username), password)){
                response = "Accepted Student";
                return response;
            }
            if (db.verifiedTeacher(Integer.parseInt(username), password)){
                response = "Accepted Teacher";
                return response;
        }


        return response;
    }

}
