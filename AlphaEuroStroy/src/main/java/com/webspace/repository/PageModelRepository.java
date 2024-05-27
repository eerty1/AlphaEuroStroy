package com.webspace.repository;

import com.webspace.model.PageModel;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("pageModelRepository")
public class PageModelRepository implements PanacheMongoRepository<PageModel> {
}
