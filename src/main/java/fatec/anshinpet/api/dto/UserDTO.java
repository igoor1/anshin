package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private List<RoleDTO> roles;
}
