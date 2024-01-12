package cars.direct.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CarRequest {

    @NotNull(message = "Car ID is required")
    private UUID carId;

    @NotNull(message = "Brand ID is required")
    private UUID brandId;

    @NotNull(message = "Type ID is required")
    private UUID typeId;

    @NotNull(message = "Model ID is required")
    private UUID modelId;

    private String iconPreview;

    @NotNull(message = "Year is required")
    private int year;

    @NotNull(message = "Mileage is required")
    private int mileage;

    @NotNull(message = "Condition is required")
    private String condition;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Seller ID is required")
    private UUID sellerId;

    @NotNull(message = "Engine capacity is required")
    private double engineCapacity;

    private String color;
    private String transmission;
    private String address;
    private int horsepower;
    private double fuelTankCapacity;
}
