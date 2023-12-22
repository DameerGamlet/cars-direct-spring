package car.direct.authorizationservice.gateway;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import car.direct.auth.dto.ClientAuthDetails;

public interface UserRestClient {

    @GetExchange( "/users/auth")
    ClientAuthDetails receiveUserAuthDetails(@RequestParam String email);
}
