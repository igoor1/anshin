package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationDTO {

    private Long id;
    private String name;
    private String manufacturer;
    private String batch;

}
