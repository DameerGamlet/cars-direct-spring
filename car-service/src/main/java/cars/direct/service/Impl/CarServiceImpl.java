package cars.direct.service.Impl;

import cars.direct.dto.request.CarRequest;
import cars.direct.dto.response.CarResponse;
import cars.direct.model.Car;
import cars.direct.repository.CarRepository;
import cars.direct.service.CarService;
import cars.direct.service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository repository;
    private CharacteristicService characteristicService;

    @Override
    public Page<CarResponse> getByBrand(Long brandId, Pageable pageable) {
//        Page<CarResponse> cars = repository.getCarsByBrand(brandId, pageable);

        return null;
    }

    @Override
    public Page<CarResponse> getByBrandAndModel(Long brandId, Long modelId, Pageable pageable) {
//        Page<Car> cars = repository.getCarsByModel(brandId, modelId, pageable);
        return null;
    }

    @Override
    public Page<CarResponse> getByType(Long typeId, Pageable pageable) {
//        Page<Car> cars = repository.getCarsByType(typeId, pageable);

        return null;
    }

    @Override
    public Page<CarResponse> getAll(Pageable pageable) {
//        Page<Car> cars = repository.getCars(pageable);

        return null;
    }

    @Override
    public Car getById(UUID carId) {
//        Optional<Car> car = repository.getCar(carId);
        return null;
    }

    @Override
    public Long getCount() {
        Long numberOfCars = repository.getNumberOfCars().longValue();
        return null;
    }

    @Override
    public void createCar(UUID sellerId, CarRequest request) {
        request.setSellerId(sellerId);
//        repository.save();
    }
}
