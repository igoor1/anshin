package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AuthDTO;
import fatec.anshinpet.api.dto.input.SigninInput;
import fatec.anshinpet.domain.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthDTO authenticate(SigninInput signinInput) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(signinInput.getEmail(), signinInput.getPassword());
        var authenticationResult = authenticationManager.authenticate(authenticationToken);
        var user = ((SecurityUser) authenticationResult.getPrincipal()).getUser();
        SecurityContextHolder.getContext().setAuthentication(authenticationResult);
        var jwt = tokenService.generateToken(user);
        return new AuthDTO(jwt.getTokenValue());
    }
}
