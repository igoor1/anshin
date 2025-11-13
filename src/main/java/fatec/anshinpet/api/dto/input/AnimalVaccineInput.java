package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AnimalVaccineInput {

    @PastOrPresent
    private LocalDate application_date;

    @NotNull
    private Long animalId;

    @NotNull
    private Long vaccineId;
}
