package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AuthDTO;
import fatec.anshinpet.api.dto.input.SigninInput;
import fatec.anshinpet.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public AuthDTO signIn(@RequestBody SigninInput signinInput) {
        return authService.authenticate(signinInput);
    }
}
