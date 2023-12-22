package cars.direct.service.Impl;

import cars.direct.model.BrandCar;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;
import cars.direct.repository.BrandCarRepository;
import cars.direct.repository.ModelCarRepository;
import cars.direct.repository.TypeCarRepository;
import cars.direct.service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {

    private TypeCarRepository typeRepository;
    private BrandCarRepository brandRepository;
    private ModelCarRepository modelRepository;


    @Override
    public List<BrandCar> getAllBrands() {
        return brandRepository.getBrands();
    }

    @Override
    public List<ModelCar> getModelsByBrand(Long brandId) {
        return modelRepository.getModelsByBrand(brandId);
    }

    @Override
    public List<TypeCar> getTypes() {
        return typeRepository.getTypes();
    }
}
