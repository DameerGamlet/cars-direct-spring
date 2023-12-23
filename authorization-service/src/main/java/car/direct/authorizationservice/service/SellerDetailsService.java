package car.direct.authorizationservice.service;

import car.direct.auth.dto.ClientAuthDetails;
import car.direct.auth.model.Role;
import car.direct.authorizationservice.dto.AuthClientDetails;
import car.direct.authorizationservice.gateway.SellerAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static car.direct.auth.util.ClientAttributes.USER_ID;

@Service
@RequiredArgsConstructor
public class SellerDetailsService implements UserDetailsService {

    private final SellerAuthClient authClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientAuthDetails clientAuthDetails = authClient.receiveSellerAuthDetails(email);

        return new AuthClientDetails(
                clientAuthDetails.email(),
                clientAuthDetails.password(),
                Set.of(new SimpleGrantedAuthority("ROLE_".concat("SELLER"))),
                clientAuthDetails.uuid().toString()
        );
    }
}