package cars.direct.service;

import cars.direct.dto.response.BrandPreview;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;

import java.util.List;

public interface CharacteristicService {
    /**
     * Получить все бренды.
     *
     * @return Список брендов.
     */
    List<BrandPreview> getAllBrands();

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
