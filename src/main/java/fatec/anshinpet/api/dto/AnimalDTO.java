package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalDTO {

    private Long id;

    private String name;

    private String color;

    private String gender;

    private LocalDate birth_date;

    private String breed;

    private String description;

    private LocalDate rescue_date;

    private AnimalTypeDTO animalType;

    private AnimalStatusDTO animalStatus;
}
