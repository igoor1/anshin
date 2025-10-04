package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AnimalDiseaseInput {

    private LocalDate diagnosis_date;
    private LocalDate recovery_date;
    private Long animalId;
    private Long diseaseId;
}
