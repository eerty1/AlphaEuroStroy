package com.webspace.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageModel extends PanacheMongoEntity {
    private String title;
    private String description;
    private String keywords;
    private String openGraphTitle;
    private String openGraphDescription;
    private String pageName;
}
