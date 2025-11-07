package fatec.anshinpet.api.dto.input;

import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.Medication;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalMedicationInput {

    @NotBlank
    private String dosage;

    @PastOrPresent
    private LocalDate start_date;

    @FutureOrPresent
    private LocalDate end_date;

    @NotNull
    private Long animalId;

    @NotNull
    private Long medicationId;
}
