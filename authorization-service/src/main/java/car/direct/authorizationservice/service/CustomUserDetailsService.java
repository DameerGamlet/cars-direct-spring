package car.direct.authorizationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import car.direct.auth.dto.ClientAuthDetails;
import car.direct.authorizationservice.dto.AuthClientDetails;
import car.direct.authorizationservice.gateway.UserRestClient;
import car.direct.exception.UserNotVerifiedYetException;

import java.util.Set;

import static car.direct.exception.messages.ExceptionMessages.USER_NOT_VERIFIED_YET;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRestClient authClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientAuthDetails clientAuthDetails = authClient.receiveUserAuthDetails(email);

        if (!clientAuthDetails.isActive()) {
            throw new UserNotVerifiedYetException(USER_NOT_VERIFIED_YET.formatted(clientAuthDetails.email()));
        }

        return new AuthClientDetails(
                clientAuthDetails.email(),
                clientAuthDetails.password(),
                Set.of(new SimpleGrantedAuthority("ROLE_".concat(clientAuthDetails.role()))),
                clientAuthDetails.uuid().toString()
        );
    }
}