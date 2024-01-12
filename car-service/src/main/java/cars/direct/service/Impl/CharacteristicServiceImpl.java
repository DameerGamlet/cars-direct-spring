package cars.direct.service.Impl;

import cars.direct.dto.response.BrandPreview;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;
import cars.direct.repository.BrandCarRepository;
import cars.direct.repository.ModelCarRepository;
import cars.direct.repository.TypeCarRepository;
import cars.direct.service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private final TypeCarRepository typeRepository;
    private final BrandCarRepository brandRepository;
    private final ModelCarRepository modelRepository;


    @Override
    public List<BrandPreview> getAllBrands() {
        return brandRepository.getBrands();
    }

    @Override
    public List<ModelCar> getModelsByBrand(UUID brandId) {
        return modelRepository.getModelsByBrand(brandId);
    }

    @Override
    public List<TypeCar> getTypes() {
        return typeRepository.getTypes();
    }
}
