package de.hse.gruppe8.jaxrs.resources;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@SecuritySchemes(value = {
        @SecurityScheme(securitySchemeName = "apiKey",
                type = SecuritySchemeType.HTTP,
                scheme = "Bearer")}
)
@SecurityRequirement(name = "apiKey")
@Path("/companies")
public class CompanyResource {

    @POST
    public Response createCompany() {

        return null;
    }

    @GET
    public Response getCompanies() {
        return Response.ok().entity(new ArrayList<>()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCompanyById(@PathParam("id") Long id) {
        return null;
    }

    @PUT
    @Path("/{id}")
    public Response updateCompany(@PathParam("id") Long id) {

        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCompany(@PathParam("id") Long id) {

        return null;
    }

}
