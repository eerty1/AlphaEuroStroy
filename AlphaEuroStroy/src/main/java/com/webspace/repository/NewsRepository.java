package com.webspace.repository;

import com.webspace.model.News;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("newsRepository")
public class NewsRepository implements PanacheMongoRepository<News> {
}
