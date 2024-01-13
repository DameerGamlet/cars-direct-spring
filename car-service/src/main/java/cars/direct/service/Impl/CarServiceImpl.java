package cars.direct.service.Impl;

import cars.direct.dto.request.CarRequest;
import cars.direct.dto.response.CarResponse;
import cars.direct.dto.response.CarResponseProjection;
import cars.direct.model.Car;
import cars.direct.repository.CarRepository;
import cars.direct.service.CarService;
import cars.direct.service.CharacteristicService;
import cars.direct.utils.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;
    private final CharacteristicService characteristicService;
    private final CarMapper carMapper;

    @Override
    public Page<CarResponse> getByBrand(Long brandId, Pageable pageable) {
        Page<CarResponse> cars = repository.getCarsByBrand(brandId, pageable);

        return null;
    }

    @Override
    public Page<CarResponse> getByBrandAndModel(Long brandId, Long modelId, Pageable pageable) {
        Page<Car> cars = repository.getCarsByModel(brandId, modelId, pageable);
        return null;
    }

    @Override
    public Page<CarResponse> getByType(Long typeId, Pageable pageable) {
        Page<Car> cars = repository.getCarsByType(typeId, pageable);

        return null;
    }

    @Override
    public Page<CarResponseProjection> getAll(Pageable pageable) {
        Page<CarResponseProjection> cars = repository.getCarsWithJoins(pageable);

        System.out.println(cars);

        return cars;
    }

    @Override
    public Car getById(UUID carId) {
        Optional<Car> car = repository.getCar(carId);
        return null;
    }

    @Override
    public Long getCount() {
        Long numberOfCars = repository.getNumberOfCars().longValue();
        return null;
    }

    @Override
    public UUID createCar(UUID sellerId, CarRequest request) {
        Car car = carMapper.mapToCar(request);
        car.setSellerId(sellerId);
        car.setCarId(UUID.randomUUID());

        System.out.println(car);

        return repository.save(car).getCarId();
    }
}
