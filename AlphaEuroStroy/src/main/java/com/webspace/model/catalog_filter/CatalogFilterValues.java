package com.webspace.model.catalog_filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CatalogFilterValues {
    private List<String> type;
    private List<String> material;
    private List<String> floors;
    private RangeProperties area;
    private RangeProperties price;
}
