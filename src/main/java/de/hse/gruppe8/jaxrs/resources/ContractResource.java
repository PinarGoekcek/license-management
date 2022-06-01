package de.hse.gruppe8.jaxrs.resources;

import de.hse.gruppe8.jaxrs.model.Company;
import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.jaxrs.model.ErrorResponse;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.jaxrs.services.ContractService;
import de.hse.gruppe8.jaxrs.services.UserService;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

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

    @Inject
    ContractService contractService;

    @Inject
    UserService userService;

    @POST
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Contract.class))),
            @APIResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    public Response createContract(@Context SecurityContext securityContext, Contract contract) {
        Long user_id = Long.valueOf(securityContext.getUserPrincipal().getName());
        User currentUser = userService.getUser(user_id);
        contract.setId(null);
        contract = contractService.createContract(currentUser, contract);
        if (contract != null) {
            return Response.ok().entity(contract).build();
        } else {
            return Response.status(401).entity(new ErrorResponse("Can`t create new Contract")).build();
        }
    }

    @GET
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Contract[].class))),
            @APIResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    public Response getContracts(@Context SecurityContext securityContext) {
        Long user_id = Long.valueOf(securityContext.getUserPrincipal().getName());
        User currentUser = userService.getUser(user_id);
        return Response.ok().entity(contractService.getContracts(currentUser)).build();
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
