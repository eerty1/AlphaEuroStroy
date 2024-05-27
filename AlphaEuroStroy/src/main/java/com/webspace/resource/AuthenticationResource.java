package com.webspace.resource;

import com.webspace.crud_service.AuthenticationService;
import com.webspace.model.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PermitAll
@Path("/auth")
public class AuthenticationResource {
    private final AuthenticationService authenticationService;
    @POST
    @Path("/login")
    public Response login(User user) {
        return authenticationService.login(user);
    }

    @POST
    @Path("/registration")
    public Response register(User user) {
        return authenticationService.register(user);
    }
}
