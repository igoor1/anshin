package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonationDTO {

    private Long id;
    private LocalDate date;
    private String Description;
    private String type;
}
