package fatec.anshinpet.api.dto;

import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.Medication;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalMedicationDTO {

    private Long id;
    private String dosage;
    private LocalDate start_date;
    private LocalDate end_date;
    private Animal animal;
    private Medication medication;
}
