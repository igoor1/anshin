package fatec.anshinpet.api.dto;

import fatec.anshinpet.domain.model.Donation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonetaryDonationDTO {

    private Long id;
    private double amount;
    private Donation donation;
}
