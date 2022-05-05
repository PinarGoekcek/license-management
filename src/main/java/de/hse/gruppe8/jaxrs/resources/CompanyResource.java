package de.hse.gruppe8.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CompanyResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer () {

        return null;
    }

    @GET
    // retreive
    public Response getCustomer ()
    {

        return null;
    }

    @PUT
    // Update
    public Response updateCustomer ()
    {

        return null;
    }

    @DELETE
    // Delete
    public Response deleteCustomer ()
    {

        return null;
    }

}
