package de.hse.gruppe8.jaxrs.resources;


import de.hse.gruppe8.exception.NoUserFoundException;
import de.hse.gruppe8.jaxrs.services.LoginService;
import de.hse.gruppe8.orm.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login (User user) {
        try {
            User  currentUser = loginService.login(user.getUsername(), user.getPassword());
            return Response.status(200).entity(currentUser).build();
        } catch (NoUserFoundException e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
    }
}