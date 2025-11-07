package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageInput {

    @NotNull
    private MultipartFile file;

    private String description;
}