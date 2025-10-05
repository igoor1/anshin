package fatec.anshinpet.api.dto.input;

import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.Medication;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalMedicationInput {

    private String dosage;
    private LocalDate start_date;
    private LocalDate end_date;
    private Long animalId;
    private Long medicationId;
}
