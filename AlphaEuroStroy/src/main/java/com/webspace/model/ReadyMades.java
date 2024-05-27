package com.webspace.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReadyMades extends PanacheMongoEntity implements Imageable {
    private String name;
    private String description;
    private String type;
    private String material;
    private Integer area;
    private String floors;
    private BigDecimal price;
    private List<Characteristic> characteristics;
    private List<String> images = new ArrayList<>();
    private long dragNdrop = count();
    @Override
    public void addImage(String imagePath) {
        images.add(imagePath);
    }
}