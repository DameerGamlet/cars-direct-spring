package cars.direct.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class CarResponse {
    private UUID carId;

    private String brandCar;

    private String typeCar;

    private String modelCar;
    private String iconPreview;

    private int year;
    private int mileage;

    private String condition;

    private BigDecimal price;
    private String sellerId;
    private double engineCapacity;

    private String color;
    private String transmission;
    private String address;
    private int horsepower;
    private double fuelTankCapacity;
}
