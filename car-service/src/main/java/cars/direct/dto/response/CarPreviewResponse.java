package cars.direct.dto.response;

import cars.direct.model.BrandCar;
import cars.direct.model.ModelCar;

import java.math.BigDecimal;

public class CarPreviewResponse {
    private BrandCar brandCar;
    private ModelCar modelCar;
    private String iconPreview;
    private int year;
    private int mileage;
    private BigDecimal price;
    private int horsepower;
}