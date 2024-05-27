package com.webspace.repository;

import com.webspace.model.Team;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("teamRepository")
public class TeamRepository implements PanacheMongoRepository<Team> {
}
