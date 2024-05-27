package com.webspace.crud_service;

import com.webspace.model.PageModel;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("pageModelCrudService")
public class PageModelCrudService extends CrudService<PageModel> {
    public PageModelCrudService(@Named("pageModelRepository") PanacheMongoRepository<PageModel> panacheMongoRepository) {
        super(panacheMongoRepository);
    }

    public PageModel findByPageName(String pageName) {
        return panacheMongoRepository.find("pageName", pageName).firstResult();
    }
}