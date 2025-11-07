package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonationInput {

    @PastOrPresent
    private LocalDate date;

    @NotBlank
    private String description;

    @NotBlank
    private String type;
}
