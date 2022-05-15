package de.hse.gruppe8.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser () {

        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser ()
    {

        return Response.ok(null).build();
    }

    @PUT
    public Response updateUser ()
    {

        return null;
    }

    @DELETE
    public Response deleteUser ()
    {

        return null;
    }

}
