package de.hse.gruppe8.jaxrs.resources;

import de.hse.gruppe8.util.JwtToken;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.security.Principal;


@Provider
@PreMatching
public class SecurityInterceptor implements ContainerRequestFilter {
    @Inject
    JwtToken jwtToken;

    // JAX-RS Security Context
    @Override
    public void filter(ContainerRequestContext context) {
        if(!context.getUriInfo().getPath().startsWith("/login")) {
            String token = context.getHeaderString("Authorization");
            try {
                Long userid = jwtToken.verifyUserToken(token);
                context.setSecurityContext(new SecurityContext() {
                    @Override
                    public Principal getUserPrincipal() {
                        return userid::toString;
                    }

                    @Override
                    public boolean isUserInRole(String role) {
                        return false;
                    }

                    @Override
                    public boolean isSecure() {
                        return false;
                    }

                    @Override
                    public String getAuthenticationScheme() {
                        return "basic";
                    }
                });
            } catch (Exception e) {
                context.abortWith(Response.status(401).build());
            }
        }
    }
}
