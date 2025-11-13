package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AnimalInput {

    @NotBlank
    private String name;

    @NotBlank
    private String color;

    @NotBlank
    private String gender;

    @PastOrPresent
    private LocalDate birth_date;

    @NotBlank
    private String breed;

    @NotBlank
    private String description;

    @PastOrPresent
    private LocalDate rescue_date;

    @NotNull
    private Long type;

    @NotNull
    private Long status;
}
