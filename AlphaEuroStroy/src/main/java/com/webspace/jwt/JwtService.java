package com.webspace.jwt;

import com.webspace.model.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class JwtService {

    public String generateJwt(User user) {
        Instant now = Instant.now();
        return Jwt.issuer("alphaeurostroy")
                .upn(user.getUsername())
                .groups(user.getRole())
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .sign();
    }
}
