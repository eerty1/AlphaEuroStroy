package com.webspace.repository;

import com.mongodb.DBRef;
import com.webspace.model.ReadyMades;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.bson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ApplicationScoped
@Named("readyMadesRepository")
public class ReadyMadesRepository implements PanacheMongoRepository<ReadyMades> {
    public List<String> findDistinctPropertyValues(String property) {
        return mongoCollection().distinct(property, BsonValue.class)
                .map(this::castValue).into(new ArrayList<>());
    }

    public List<ReadyMades> filterCatalog(int page, int size, Document document){
        return find(document).page(Page.of(page, size)).list();
    }

    public long countByCatalogFilter(Document document) {
        return count(document);
    }

    private String castValue(BsonValue value) {
        return switch (value.getBsonType()) {
            case INT32 -> String.valueOf(value.asInt32().getValue());
            case INT64 -> String.valueOf(value.asInt64().getValue());
            case STRING -> value.asString().getValue();
            case DECIMAL128 -> String.valueOf(value.asDecimal128().doubleValue());
            case DOUBLE -> String.valueOf(value.asDouble().getValue());
            case BOOLEAN -> String.valueOf(value.asBoolean().getValue());
            case OBJECT_ID -> value.asObjectId().getValue().toString();
            case DB_POINTER -> new DBRef(value.asDBPointer().getNamespace(), value.asDBPointer().getId()).toString();
            case BINARY -> Arrays.toString(value.asBinary().getData());
            case DATE_TIME -> new Date(value.asDateTime().getValue()).toString();
            case SYMBOL -> value.asSymbol().getSymbol();
            case ARRAY -> Arrays.toString(value.asArray().toArray());
            case DOCUMENT -> Document.parse(value.asDocument().toJson()).toJson();
            default -> "Нет значений";
        };
    }
}
