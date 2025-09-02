package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.UserDTO;
import fatec.anshinpet.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.parseObject;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtEncoder jwtEncoder;

    public Jwt generateToken(User user) {
        Instant now = Instant.now();
        var parsedUser = parseObject(user, UserDTO.class);
        var scopes = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("anshinpet")
                .subject(user.getName())
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .claim("user", parsedUser)
                .claim("scope", scopes)
                .build();
        var header = JwsHeader.with(SignatureAlgorithm.RS256).type("JWT").build();
        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims));
    }

}
