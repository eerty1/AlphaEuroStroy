package com.webspace.repository;

import com.webspace.model.Portfolio;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("portfolioRepository")
public class PortfolioRepository implements PanacheMongoRepository<Portfolio> {
}