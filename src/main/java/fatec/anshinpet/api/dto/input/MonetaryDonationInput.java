package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonetaryDonationInput {

    @Positive
    private Double amount;

    @NotNull
    private Long donationId;
}
