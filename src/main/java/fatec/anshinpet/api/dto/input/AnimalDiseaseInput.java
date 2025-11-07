package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AnimalDiseaseInput {

    @PastOrPresent
    private LocalDate diagnosis_date;

    @FutureOrPresent
    private LocalDate recovery_date;

    @NotNull
    private Long animalId;

    @NotNull
    private Long diseaseId;
}
