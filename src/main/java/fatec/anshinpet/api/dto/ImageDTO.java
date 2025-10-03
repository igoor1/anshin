package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDTO {

    private String fileName;
    private String description;
    private String contentType;
    private String size;
}
