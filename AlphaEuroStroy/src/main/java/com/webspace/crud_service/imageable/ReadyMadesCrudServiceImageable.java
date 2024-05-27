package com.webspace.crud_service.imageable;

import com.webspace.image_utils.ImageUtils;
import com.webspace.model.catalog_filter.CatalogFilterValues;
import com.webspace.model.ReadyMades;
import com.webspace.repository.ReadyMadesRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.bson.Document;

import java.util.List;
import java.util.Map;

@ApplicationScoped
@Named("readyMadesCrudServiceImageable")
public class ReadyMadesCrudServiceImageable extends CrudServiceImageable<ReadyMades> {
    private final ReadyMadesRepository readyMadesRepository = ((ReadyMadesRepository) panacheMongoRepository);

    public ReadyMadesCrudServiceImageable(@Named("readyMadesRepository") PanacheMongoRepository<ReadyMades> panacheMongoRepository, ImageUtils imageUtils) {
        super(panacheMongoRepository, imageUtils);
    }

    public Map<Integer, List<ReadyMades>> filterCatalog(int page, int size, CatalogFilterValues catalogFilterValues){
        Document document = buildCatalogFilterQueryDocument(catalogFilterValues);
        return Map.of(
                calculateAmountOfPages(
                        readyMadesRepository.countByCatalogFilter(document), size
                ),
                readyMadesRepository.filterCatalog(page, size, document));
    }

    public List<String> findDistinctPropertyValues(String property) {
        return readyMadesRepository.findDistinctPropertyValues(property);
    }

    private Document buildCatalogFilterQueryDocument(CatalogFilterValues catalogFilterValues) {
        return new Document(
                Map.of(
                        "type", new Document("$in", catalogFilterValues.getType()),
                        "material", new Document("$in", catalogFilterValues.getMaterial()),
                        "floors", new Document("$in", catalogFilterValues.getFloors()),
                        "area", new Document(Map.of(
                                "$gte", catalogFilterValues.getArea().getFrom(),
                                "$lte", catalogFilterValues.getArea().getTo()
                        )),
                        "price", new Document(Map.of(
                                "$gte", catalogFilterValues.getPrice().getFrom(),
                                "$lte", catalogFilterValues.getPrice().getTo()
                        ))
                )
        );
    }
}