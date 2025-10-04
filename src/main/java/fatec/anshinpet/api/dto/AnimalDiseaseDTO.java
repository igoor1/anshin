package fatec.anshinpet.api.dto;

import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.Disease;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalDiseaseDTO {

    private Long id;
    private LocalDate diagnosis_date;
    private LocalDate recovery_date;
    private Animal animal;
    private Disease disease;
}
