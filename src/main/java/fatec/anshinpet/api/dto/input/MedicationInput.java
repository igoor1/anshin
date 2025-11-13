package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationInput {

    @NotBlank
    private String name;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String batch;

}
