package fatec.anshinpet.domain.service;

import fatec.anshinpet.domain.exception.ImageNotFoundException;
import fatec.anshinpet.domain.model.Image;
import fatec.anshinpet.domain.repository.ImageRepository;
import fatec.anshinpet.domain.service.ImageStorageService.NewImage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageStorageService  imageStorageService;

    public Image getImageJsonOrException(Long id) {
        return imageRepository.findById(id).orElseThrow(
                () -> new ImageNotFoundException("image not found")
        );
    }

    public Image getImageJsonByEntityOrException(Image imageEntity) {
        try {
            return imageRepository.findById(imageEntity.getId()).orElseThrow(
                    () -> new ImageNotFoundException("")
            );
        } catch (NullPointerException e) {
            throw new ImageNotFoundException("message", e);
        }
    }

    public ResponseEntity<InputStreamResource> getImage(Image imageEntity) {
        Image image = getImageJsonByEntityOrException(imageEntity);
        MediaType imageMediaType = MediaType.parseMediaType(image.getContentType());
        var imageStream = imageStorageService.retrieve(image.getFileName());
        return ResponseEntity.ok().contentType(imageMediaType).body(new InputStreamResource(imageStream));
    }

    @Transactional
    public Image save(Image image, InputStream fileInputStream) {
        String newImageName = imageStorageService.generateFileName(image.getFileName());
        String existingFileName = null;
        image.setFileName(newImageName);

//        var existingImage = imageRepository.findImageByFileName(image.getFileName());
//        if (existingImage.isPresent()) {
//            existingFileName = existingImage.get().getFileName();
//            imageRepository.delete(existingImage.get());
//            imageRepository.flush();
//        }

        image = imageRepository.save(image);
        imageRepository.flush();
        var newImage = NewImage.builder()
                .fileName(image.getFileName())
                .contentType(image.getContentType())
                .inputStream(fileInputStream)
                .build();
        imageStorageService.replace(newImage, existingFileName);
        return image;
    }

    @Transactional
    public void delete(Image image) {
        image = getImageJsonByEntityOrException(image);
        imageRepository.delete(image);
        imageRepository.flush();
        imageStorageService.remove(image.getFileName());
    }
}
