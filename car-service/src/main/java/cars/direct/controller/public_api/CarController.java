package cars.direct.controller.public_api;

import cars.direct.dto.response.CarResponse;
import cars.direct.dto.response.CarResponseProjection;
import cars.direct.model.Car;
import cars.direct.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static car.direct.util.HttpUtils.PUBLIC_API_VI;

@RestController
@RequiredArgsConstructor
@RequestMapping(PUBLIC_API_VI + "/cars")
public class CarController implements CarsApi{

    private final CarService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CarResponseProjection> getCars(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/brands/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarResponse> getCarsByBrand(@PathVariable Long brandId, Pageable pageable) {
        return service.getByBrand(brandId, pageable);
    }

    @GetMapping("/brands/{brandId}/models/{modelId}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarResponse> getCarsByBrandAndModel(@PathVariable Long brandId, @PathVariable Long modelId, Pageable pageable) {
        return service.getByBrandAndModel(brandId, modelId, pageable);
    }

    @GetMapping("/types/{typeId}")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarResponse> getCarsByType(@PathVariable Long typeId, Pageable pageable) {
        return service.getByType(typeId, pageable);
    }

    @GetMapping("/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable UUID carId) {
        return service.getById(carId);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long getNumbersOfCars() {
        return service.getCount();
    }
}
