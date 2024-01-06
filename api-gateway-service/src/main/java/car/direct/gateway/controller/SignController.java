package car.direct.gateway.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import car.direct.gateway.dto.LoginRequest;
import car.direct.gateway.dto.OAuthClientResponse;
import car.direct.gateway.service.OAuthAuthenticationService;

import static car.direct.util.HttpUtils.PUBLIC_API_VI;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(PUBLIC_API_VI)
public class SignController implements SignApi {

    @Autowired
    private final OAuthAuthenticationService authenticationService;

    @PostMapping("/users/oauth/login")
    public Mono<OAuthClientResponse> loginUser(@RequestBody Mono<LoginRequest> request) {
        return authenticationService.authenticateUser(request);
    }

    @PostMapping("/sellers/oauth/login")
    public Mono<OAuthClientResponse> loginSeller(@RequestBody Mono<LoginRequest> request) {
        return authenticationService.authenticateSeller(request);
    }

    @PostMapping("/oauth/logout")
    public Mono<ResponseEntity<Void>> logout(ServerHttpRequest request) {
        return authenticationService.clearAuthentication(request);
    }
}