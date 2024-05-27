package com.webspace.crud_service;

import com.webspace.jwt.JwtService;
import com.webspace.model.User;
import com.webspace.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.core.Response;

import java.net.URI;

import static jakarta.ws.rs.core.Response.Status.CONFLICT;
import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;

@ApplicationScoped
public class AuthenticationService {
    protected JwtService jwtService;
    protected PanacheMongoRepository<User> panacheMongoRepository;

    public AuthenticationService(JwtService jwtService, @Named("userRepository") PanacheMongoRepository<User> panacheMongoRepository) {
        this.jwtService = jwtService;
        this.panacheMongoRepository = panacheMongoRepository;
    }

    public Response login(User user) {
        User dbUser = ((UserRepository) panacheMongoRepository).findByUsername(user.getUsername());
        if (BcryptUtil.matches(user.getPassword(), dbUser.getPassword())) {
            return Response.ok(jwtService.generateJwt(dbUser)).build();
        }
        return Response.status(UNAUTHORIZED).build();
    }

    public Response register(User user) {
        if (panacheMongoRepository.count("username", user.getUsername()) < 1) {
            user.setPassword(
                    BcryptUtil.bcryptHash(user.getPassword())
            );
            panacheMongoRepository.persist(user);
            return Response.created(URI.create("/" + user.id)).build();
        }

        return Response.status(CONFLICT).build();
    }
}
