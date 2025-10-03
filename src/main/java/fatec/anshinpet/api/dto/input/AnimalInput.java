package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AnimalInput {

    private String name;
    private String color;
    private String gender;
    private LocalDate birth_date;
    private String breed;
    private String description;
    private LocalDate rescue_date;
    private Long type;
    private Long status;
}
