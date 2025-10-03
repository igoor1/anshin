package fatec.anshinpet.infrastructure.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import fatec.anshinpet.domain.service.ImageStorageService;
import fatec.anshinpet.infrastructure.exception.StorageException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class R2StorageService implements ImageStorageService {

    private final AmazonS3 amazonS3;

    @Value("${r2.bucket.name}")
    private String storagePath;

    @Override
    public InputStream retrieve(String fileName) {
        try {
            S3Object s3Object = amazonS3.getObject(storagePath, fileName);
            return s3Object.getObjectContent();
        } catch (Exception e) {
            throw new StorageException("Não foi possivel recuperar o arquivo.", e);
        }
    }

    @Override
    public void save(NewImage newImage) {
        try {
            var metadata = new ObjectMetadata();
            metadata.setContentType(newImage.getContentType());
            metadata.setContentLength(newImage.getInputStream().available());

            var putObjectRequest = new PutObjectRequest(
                    storagePath,

                    newImage.getFileName(),
                    newImage.getInputStream(),
                    metadata
            );

            amazonS3.putObject(putObjectRequest);
        } catch (Exception e) {
            throw new StorageException("", e);
        }
    }

    @Override
    public void remove(String fileName) {
        try {
            var deleteObjectRequest = new DeleteObjectRequest(storagePath, fileName);
            amazonS3.deleteObject(deleteObjectRequest);
        } catch (Exception e) {
            throw new StorageException("", e);
        }
    }

    public String getFileUrl(String fileName) {
        URL url = amazonS3.getUrl(storagePath, fileName);
        return url.toString();
    }
}
