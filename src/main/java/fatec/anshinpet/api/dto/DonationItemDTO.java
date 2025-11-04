package fatec.anshinpet.api.dto;

import fatec.anshinpet.domain.model.Donation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationItemDTO {

    private Long id;
    private Integer quantity;
    private Donation donation;
}
