package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonetaryDonationInput {

    private double amount;
    private Long donationId;
}
