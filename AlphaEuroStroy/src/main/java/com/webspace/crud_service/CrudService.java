package com.webspace.crud_service;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class CrudService<T> {
    protected PanacheMongoRepository<T> panacheMongoRepository;

    public CrudService(PanacheMongoRepository<T> panacheMongoRepository) {
        this.panacheMongoRepository = panacheMongoRepository;
    }

    public T findById(String id) {
        return panacheMongoRepository.findById(new ObjectId(id));
    }

    public List<T> findAll(String sort, Sort.Direction direction) {
        return panacheMongoRepository.listAll(Sort.by(sort, direction));
    }

    public Map<Integer, List<T>> findAll(int page, int size, String sort, Sort.Direction direction) {
        return Map.of(
                calculateAmountOfPages(panacheMongoRepository.count(), size),
                panacheMongoRepository
                        .findAll(Sort.by(sort, direction))
                        .page(Page.of(page, size))
                        .list()
        );
    }

    public void create(T entity) {
        panacheMongoRepository.persist(entity);
    }

    public void update(T entity) {
        panacheMongoRepository.update(entity);
    }

    public void delete(String id) {
        panacheMongoRepository.deleteById(new ObjectId(id));
    }

    public void changeOrder(List<T> entities) {
        panacheMongoRepository.update(entities);
    }

    protected int calculateAmountOfPages(long countAll, int requestedSize) {
        return (int) Math.ceil(countAll / (double) requestedSize);
    }
}
