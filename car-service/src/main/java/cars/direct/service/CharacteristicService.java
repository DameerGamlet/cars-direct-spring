package cars.direct.service;

import cars.direct.dto.response.BrandPreview;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;

import java.util.List;
import java.util.UUID;

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
    List<ModelCar> getModelsByBrand(UUID brandId);

    /**
     * Получить типы автомобилей.
     *
     * @return Список типов.
     */
    List<TypeCar> getTypes();
}
