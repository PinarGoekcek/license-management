package de.hse.gruppe8.jaxrs.resources;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@SecuritySchemes(value = {
        @SecurityScheme(securitySchemeName = "apiKey",
                type = SecuritySchemeType.HTTP,
                scheme = "Bearer")}
)
@SecurityRequirement(name = "apiKey")
@Path("/contracts")
public class ContractResource {

    @POST
    public Response createContract() {

        return null;
    }

    @GET
    public Response getContract() {
        return null;
    }

    @GET
    @Path("/{id}")
    public Response getContractById(@PathParam("id") Long id) {
        return null;
    }

    @PUT
    @Path("/{id}")
    public Response updateContract(@PathParam("id") Long id) {

        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContract(@PathParam("id") Long id) {

        return null;
    }

}
