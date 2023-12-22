package cars.direct.service;

import cars.direct.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CarService {

    /**
     * Получить автомобили по бренду.
     *
     * @param brandId ID бренда.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<Car> getByBrand(Long brandId, Pageable pageable);

    /**
     * Получить автомобили по бренду и модели.
     *
     * @param brandId ID бренда.
     * @param modelId ID модели.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<Car> getByBrandAndModel(Long brandId, Long modelId, Pageable pageable);

    /**
     * Получить автомобили по типу.
     *
     * @param typeId ID типа.
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<Car> getByType(Long typeId, Pageable pageable);

    /**
     * Получить все автомобили.
     *
     * @param pageable Страница.
     * @return Страница автомобилей.
     */
    Page<Car> getAll(Pageable pageable);

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

    /**
     * Получить все бренды.
     *
     * @return Список брендов.
     */
    List<BrandCar> getAllBrands();

    /**
     * Получить модели для определённого бренда.
     *
     * @param brandId ID бренда.
     * @return Список моделей.
     */
    List<ModelCar> getModelsByBrand(Long brandId);

    /**
     * Получить типы автомобилей.
     *
     * @return Список типов.
     */
    List<TypeCar> getTypes();
}
