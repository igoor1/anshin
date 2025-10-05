package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationInput {

    private String name;

    private String manufacturer;

    private String batch;

}
