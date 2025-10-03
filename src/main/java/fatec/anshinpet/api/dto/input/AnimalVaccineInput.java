package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AnimalVaccineInput {


    private LocalDate application_date;
    private Long animalId;
    private Long vaccineId;
}
