package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AuthDTO;
import fatec.anshinpet.api.dto.UserDTO;
import fatec.anshinpet.api.dto.input.SigninInput;
import fatec.anshinpet.api.dto.input.UserInput;
import fatec.anshinpet.domain.model.User;
import fatec.anshinpet.domain.service.AuthService;
import fatec.anshinpet.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO signUp(@RequestBody @Valid UserInput userInput) {
        User user = parseObject(userInput, User.class);
        user = userService.create(user, userInput.getRole());
        return parseObject(user, UserDTO.class);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public AuthDTO signIn(@RequestBody @Valid SigninInput signinInput) {
        return authService.authenticate(signinInput);
    }

}
