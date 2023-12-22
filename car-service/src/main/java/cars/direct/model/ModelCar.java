package cars.direct.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "models-car")
public class ModelCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID modelId;

    @NotBlank(message = "Name is required")
    private String name;

    @ManyToOne(optional = false)
    private BrandCar brandCar;
}