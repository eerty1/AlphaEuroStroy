package com.webspace.repository;

import com.webspace.model.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("userRepository")
public class UserRepository implements PanacheMongoRepository<User> {
    public User findByUsername(String username){
        return find("username", username).firstResult();
    }
}
