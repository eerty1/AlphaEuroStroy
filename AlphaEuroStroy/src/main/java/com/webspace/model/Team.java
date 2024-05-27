package com.webspace.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team extends PanacheMongoEntity implements Imageable {
    private String name;
    private String position;
    private List<String> images = new ArrayList<>();
    private long dragNdrop = count();
    @Override
    public void addImage(String imagePath) {
        images.add(imagePath);
    }
}
