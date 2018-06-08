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

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String login(User u){

        String response = "Not Accepted";
        int username=u.getUsername();
        String password=u.getPassword();
        Database b = new Database();

            if (!AuthUtils.verifiedCredentials(Integer.toString(username),password)){
                response = "You must enter valid username and password";
                return response;
            }
            if (!AuthUtils.securedPassword(Integer.toString(username), password)){
                response = "You must enter a secure password";
                return response;
            }
            if (b.verifiedUser(username,password)){
                response = "Accepted";
                return response;
            }

        return response;
    }

}
