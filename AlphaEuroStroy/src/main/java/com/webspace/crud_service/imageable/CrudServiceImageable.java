package com.webspace.crud_service.imageable;

import com.webspace.crud_service.CrudService;
import com.webspace.image_utils.Directory;
import com.webspace.image_utils.ImageUtils;
import com.webspace.model.Imageable;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public abstract class CrudServiceImageable<T extends Imageable> extends CrudService<T> {
    protected ImageUtils imageUtils;

    public CrudServiceImageable(PanacheMongoRepository<T> panacheMongoRepository, ImageUtils imageUtils) {
        super(panacheMongoRepository);
        this.imageUtils = imageUtils;
    }

    public void create(T entity, List<FileUpload> images, Directory directory) {
        saveImages(entity, images, directory);
        super.create(entity);
    }

    public void update(T entity, List<FileUpload> images, Directory directory) {
        if (!entity.getImages().isEmpty()) {
            imageUtils.deleteImages(entity.getImages());
            entity.setImages(new ArrayList<>());
        }
        saveImages(entity, images, directory);
        super.update(entity);
    }

    public void delete(String id) {
        T entity = panacheMongoRepository.findById(new ObjectId(id));
        imageUtils.deleteImages(entity.getImages());
        panacheMongoRepository.delete(entity);
    }

    private void saveImages(T entity, List<FileUpload> images, Directory directory) {
        images.forEach(image -> entity
                .addImage(
                        imageUtils.saveImage(image, directory.getDirectoryName())
                )
        );
    }
}
