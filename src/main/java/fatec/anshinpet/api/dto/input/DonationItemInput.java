package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationItemInput {

    private Integer quantity;
    private Long donationId;
}
