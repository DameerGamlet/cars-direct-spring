package car.direct.authorizationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static car.direct.auth.util.ClientAttributes.USER_ID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtEncoder jwtEncoder;

    @Value("${services.auth.url}")
    private String AUTH_SERVICE_URL;

    private JwtClaimsSet createJwtClaimsSet(Authentication authentication, long expiresAtInMinutes) {
        Set<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        Instant issuedAt = Instant.now(),
                expiredAt = issuedAt.plus(expiresAtInMinutes, ChronoUnit.MINUTES);

        return JwtClaimsSet.builder()
                .issuer(AUTH_SERVICE_URL)
                .issuedAt(issuedAt)
                .notBefore(issuedAt)
                .expiresAt(expiredAt)
                .audience(List.of("client"))
                .subject(authentication.getName())
                .claim("scope", Set.of("openid"))
                .claim("authorities", authorities).claim(
                        USER_ID,
                        ((Map<?, ?>) authentication.getDetails()).get(USER_ID)
                ).build();
    }

    @SuppressWarnings("unchecked")
    public OAuth2AccessToken createAccessToken(Authentication authentication, long expiresAtInMinutes) {
        JwtClaimsSet jwtClaimsSet = createJwtClaimsSet(authentication, expiresAtInMinutes);

        return new OAuth2AccessToken(
                OAuth2AccessToken.TokenType.BEARER,
                jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue(),
                jwtClaimsSet.getIssuedAt(),
                jwtClaimsSet.getExpiresAt(),
                jwtClaimsSet.getClaim("scope")
        );
    }

    @SuppressWarnings("unchecked")
    public OAuth2RefreshToken createRefreshToken(Authentication authentication, long expiresAtInMinutes) {
        JwtClaimsSet jwtClaimsSet = createJwtClaimsSet(authentication, expiresAtInMinutes);

        return new OAuth2RefreshToken(
                jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue(),
                jwtClaimsSet.getIssuedAt(),
                jwtClaimsSet.getExpiresAt()
        );
    }
}