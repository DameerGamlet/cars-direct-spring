package car.direct.mailsender.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import car.direct.mailsender.model.UserMailRequest;
import car.direct.mailsender.service.RegistrationSenderService;

import static car.direct.util.HttpUtils.PUBLIC_API_VI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(PUBLIC_API_VI)
public class RegistrationController {

    @Autowired
    private final RegistrationSenderService service;

    @PostMapping("/mail/send/activation")
    public void sendActivationEmail(@RequestBody UserMailRequest user, @RequestParam String token) {
        service.sendTokenToUser(user, token);
    }
}
