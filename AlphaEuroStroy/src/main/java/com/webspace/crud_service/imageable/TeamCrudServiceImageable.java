package com.webspace.crud_service.imageable;

import com.webspace.image_utils.ImageUtils;
import com.webspace.model.Team;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("teamCrudServiceImageable")
public class TeamCrudServiceImageable extends CrudServiceImageable<Team> {
    public TeamCrudServiceImageable(@Named("teamRepository") PanacheMongoRepository<Team> panacheMongoRepository, ImageUtils imageUtils) {
        super(panacheMongoRepository, imageUtils);
    }
}