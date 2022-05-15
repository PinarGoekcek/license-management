package de.hse.gruppe8.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
public class CompanyResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompany () {

        return null;
    }

    @GET
    // retreive
    public Response getCompany ()
    {

        return null;
    }

    @PUT
    // Update
    public Response updateCompany ()
    {

        return null;
    }

    @DELETE
    // Delete
    public Response deleteCompany ()
    {

        return null;
    }

}
