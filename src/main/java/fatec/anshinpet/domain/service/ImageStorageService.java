package fatec.anshinpet.domain.service;

import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;
import java.util.UUID;

public interface ImageStorageService {

    InputStream retrieve(String fileName);

    void save(NewImage newImage);

    void remove(String fileName);

    default void replace(NewImage newImage, String oldFileName) {
        save(newImage);
        if (oldFileName != null) {
            this.remove(oldFileName);
        }
    }

    default String generateFileName(String originalName) {
        return UUID.randomUUID() + "_" + originalName;
    }

    @Builder
    @Getter
    class NewImage {
        private String fileName;
        private InputStream inputStream;
        private String contentType;
    }

}
