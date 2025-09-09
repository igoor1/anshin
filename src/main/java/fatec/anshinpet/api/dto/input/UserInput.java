package fatec.anshinpet.api.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {

    private String email;
    private String name;
    private String password;
    private String role;
}
