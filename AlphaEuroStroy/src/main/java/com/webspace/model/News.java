package com.webspace.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class News extends PanacheMongoEntity implements Imageable {
    private String title;
    private String subtitle;
    private Long date;
    private String body;
    private List<String> images = new ArrayList<>();

    @Override
    public void addImage(String imagePath) {
        images.add(imagePath);
    }
}
