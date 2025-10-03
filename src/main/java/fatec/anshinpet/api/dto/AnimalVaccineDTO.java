package fatec.anshinpet.api.dto;

import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.Vaccine;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalVaccineDTO {

    private Long id;
    private LocalDate application_date;
    private Animal animal;
    private Vaccine vaccine;
}
