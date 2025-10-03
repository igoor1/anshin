package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageInput {

    private MultipartFile file;

    private String description;
}