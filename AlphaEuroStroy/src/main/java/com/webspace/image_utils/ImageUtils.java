package com.webspace.image_utils;

import com.webspace.exception.ImagePersistenceException;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.io.FilenameUtils;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

import static com.webspace.image_utils.Directory.BACKEND;
import static com.webspace.image_utils.Directory.ROOT;

@ApplicationScoped
public class ImageUtils {
    public String saveImage(FileUpload image, String imageStorageDirectory) {
        String fileExtension = FilenameUtils.getExtension(image.fileName());

        String filename = UUID.randomUUID() + "." + fileExtension;
        File filePath = new File(ROOT.getDirectoryName() + BACKEND.getDirectoryName() + imageStorageDirectory + filename);

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(
                    Files.readAllBytes(image.uploadedFile())
            );
            return BACKEND.getDirectoryName() + imageStorageDirectory + filename;
        } catch (IOException e) {
            throw new ImagePersistenceException("Ошибка сохранения фотографии");
        }
    }

    public void deleteImages(List<String> images) {
        images.forEach(image -> {
            File file = new File(ROOT.getDirectoryName() + image);
            file.delete();
        });
    }
}
