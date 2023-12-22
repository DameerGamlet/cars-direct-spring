package cars.direct.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "cars")
public class Car {

    @Id
    private Long id;

    private UUID carId;

    @ManyToOne(optional = false)
    private BrandCar brandCar;

    @ManyToOne(optional = false)
    private TypeCar typeCar;

    @ManyToOne(optional = false)
    private ModelCar modelCar;
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
