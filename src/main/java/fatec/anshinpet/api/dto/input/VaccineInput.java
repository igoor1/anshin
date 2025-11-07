package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VaccineInput {

    @NotBlank
    private String name;

    @NotBlank
    private String manufacturer;
}
