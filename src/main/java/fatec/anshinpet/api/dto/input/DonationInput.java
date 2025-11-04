package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonationInput {

    private LocalDate date;
    private String Description;
    private String type;
}
