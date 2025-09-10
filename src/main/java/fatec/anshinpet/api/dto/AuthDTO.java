package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {

    private  String accessToken;

    public AuthDTO(String tokenValue) {
        this.accessToken = tokenValue;
    }

}
