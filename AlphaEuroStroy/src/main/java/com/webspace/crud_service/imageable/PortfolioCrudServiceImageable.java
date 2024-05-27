package com.webspace.crud_service.imageable;

import com.webspace.image_utils.ImageUtils;
import com.webspace.model.Portfolio;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("portfolioCrudServiceImageable")
public class PortfolioCrudServiceImageable extends CrudServiceImageable<Portfolio> {
    public PortfolioCrudServiceImageable(@Named("portfolioRepository") PanacheMongoRepository<Portfolio> panacheMongoRepository, ImageUtils imageUtils) {
        super(panacheMongoRepository, imageUtils);
    }
}