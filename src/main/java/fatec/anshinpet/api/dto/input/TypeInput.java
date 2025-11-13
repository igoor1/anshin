package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeInput {

    @NotBlank
    private String name;
}
