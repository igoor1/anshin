package fatec.anshinpet.api.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationItemInput {

    @NotNull
    private Integer quantity;

    @NotNull
    private Long donationId;
}
