package cars.direct.controller.private_api;

import cars.direct.dto.request.CarRequest;
import cars.direct.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static car.direct.util.HttpUtils.PRIVATE_API_VI;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRIVATE_API_VI + "/sellers")
public class CarSellerController {
    // TODO: необходимо требовать токен

    private final CarService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/{sellerId}")
    public void createNewCar(@PathVariable("sellerId") UUID sellerId, @RequestBody CarRequest request) {
        service.createCar(sellerId, request);
    }
}
