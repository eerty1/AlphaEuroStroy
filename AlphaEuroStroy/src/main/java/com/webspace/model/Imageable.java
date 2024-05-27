package com.webspace.model;

import java.util.List;

public interface Imageable {
    List<String> getImages();

    void setImages(List<String> images);

    void addImage(String imagePath);
}
