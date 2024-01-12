package cars.direct.service;

import cars.direct.dto.request.CarRequest;
import cars.direct.dto.response.CarResponse;
import cars.direct.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface CarService {

    /**
     * Получить автомобили по бренду.
     *
     * @param brandId ID бренда.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<CarResponse> getByBrand(Long brandId, Pageable pageable);

    /**
     * Получить автомобили по бренду и модели.
     *
     * @param brandId ID бренда.
     * @param modelId ID модели.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<CarResponse> getByBrandAndModel(Long brandId, Long modelId, Pageable pageable);

    /**
     * Получить автомобили по типу.
     *
     * @param typeId ID типа.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<CarResponse> getByType(Long typeId, Pageable pageable);

    /**
     * Получить все автомобили.
     *
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<CarResponse> getAll(Pageable pageable);

    /**
     * Получить автомобиль по ID.
     *
     * @param carId ID автомобиля.
     * @return Автомобиль.
     */
    Car getById(UUID carId);

    /**
     * Получить количество автомобилей.
     *
     * @return Количество автомобилей.
     */
    Long getCount();

    void createCar(UUID sellerId, CarRequest request);
}
