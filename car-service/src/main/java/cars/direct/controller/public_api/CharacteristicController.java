package cars.direct.controller.public_api;

import cars.direct.dto.response.BrandPreview;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;
import cars.direct.service.CharacteristicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static car.direct.util.HttpUtils.PUBLIC_API_VI;

@RestController
@RequiredArgsConstructor
@RequestMapping(PUBLIC_API_VI + "/cars")
public class CharacteristicController implements CharacteristicApi {

    private final CharacteristicService characteristicService;

    @GetMapping("/brands")
    public List<BrandPreview> getAllBrands() {
        return characteristicService.getAllBrands();
    }

    @GetMapping("/brands/{brandId}/models")
    public List<ModelCar> getModelsByBrand(@PathVariable UUID brandId) {
        return characteristicService.getModelsByBrand(brandId);
    }

    @GetMapping("/types")
    public List<TypeCar> getTypes() {
        return characteristicService.getTypes();
    }
}
