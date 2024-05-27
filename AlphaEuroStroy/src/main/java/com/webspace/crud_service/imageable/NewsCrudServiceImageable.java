package com.webspace.crud_service.imageable;

import com.webspace.image_utils.ImageUtils;
import com.webspace.model.News;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("newsCrudServiceImageable")
public class NewsCrudServiceImageable extends CrudServiceImageable<News> {
    public NewsCrudServiceImageable(@Named("newsRepository") PanacheMongoRepository<News> panacheMongoRepository, ImageUtils imageUtils) {
        super(panacheMongoRepository, imageUtils);
    }
}
