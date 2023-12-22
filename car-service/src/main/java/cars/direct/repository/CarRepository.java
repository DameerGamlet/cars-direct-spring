package cars.direct.repository;

import cars.direct.dto.response.CarResponse;
import cars.direct.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    /*    @Query(
                value = """
                            SELECT
                              car.id AS carId,
                              car.brand_id AS brandCarId,
                              brand.name AS brandCar,
                              car.type_id AS typeCarId,
                              type.name AS typeCar,
                              car.model_id AS modelCarId,
                              model.name AS modelCar,
                              car.icon_preview,
                              car.year,
                              car.mileage,
                              car.condition,
                              car.price,
                              car.seller_id,
                              car.engine_capacity,
                              car.color,
                              car.transmission,
                              car.address,
                              car.horsepower,
                              car.fuel_tank_capacity
                            FROM cars car
                            INNER JOIN brands brand ON car.brand_id = brand.id
                            INNER JOIN types type ON car.type_id = type.id
                            INNER JOIN models model ON car.model_id = model.id
                            WHERE brand.id = :brandId
                            ORDER BY car.id
                        """,
                nativeQuery = true
    //            ,
    //            countQuery = """
    //                        SELECT COUNT(*)
    //                        FROM cars car
    //                        INNER JOIN brands brand ON car.brand_id = brand.id
    //                        INNER JOIN types type ON car.type_id = type.id
    //                        INNER JOIN models model ON car.model_id = model.id
    //                        WHERE brand.id = :brandId
    //                    """
        )*/
    @Query(value = "SELECT c FROM cars c WHERE c.brand_car_id=:brandId", nativeQuery = true)
    Page<CarResponse> getCarsByBrand(@Param("brandId") Long brandId, Pageable pageable);

    /*     @Query(
             value = """
                         SELECT
                           car.id AS carId,
                           car.brand_id AS brandCarId,
                           brand.name AS brandCar,
                           car.type_id AS typeCarId,
                           type.name AS typeCar,
                           car.model_id AS modelCarId,
                           model.name AS modelCar,
                           car.icon_preview,
                           car.year,
                           car.mileage,
                           car.condition,
                           car.price,
                           car.seller_id,
                           car.engine_capacity,
                           car.color,
                           car.transmission,
                           car.address,
                           car.horsepower,
                           car.fuel_tank_capacity
                         FROM cars car
                         INNER JOIN brands brand ON car.brand_id = brand.id
                         INNER JOIN types type ON car.type_id = type.id
                         INNER JOIN models model ON car.model_id = model.id
                         WHERE brand.id = :brandId AND model.id = modelId
                         ORDER BY car.id
                         OFFSET :pageable.offset
                         LIMIT :pageable.pageSize;
                     """,
             nativeQuery = true
     )*/
    @Query(value = "SELECT c FROM cars c WHERE c.brand_car_id=:brandId AND model_car_id=:modelId", nativeQuery = true)
    Page<Car> getCarsByModel(@Param("brandId") Long brandId, @Param("modelId") Long modelId, Pageable pageable);

    /*    @Query(
                value = """
                            SELECT
                              car.id AS carId,
                              car.brand_id AS brandCarId,
                              brand.name AS brandCar,
                              car.type_id AS typeCarId,
                              type.name AS typeCar,
                              car.model_id AS modelCarId,
                              model.name AS modelCar,
                              car.icon_preview,
                              car.year,
                              car.mileage,
                              car.condition,
                              car.price,
                              car.seller_id,
                              car.engine_capacity,
                              car.color,
                              car.transmission,
                              car.address,
                              car.horsepower,
                              car.fuel_tank_capacity
                            FROM cars car
                            INNER JOIN brands brand ON car.brand_id = brand.id
                            INNER JOIN types type ON car.type_id = type.id
                            INNER JOIN models model ON car.model_id = model.id
                            WHERE type.id = :typeId
                            ORDER BY car.id
                            OFFSET :pageable.offset
                            LIMIT :pageable.pageSize;
                        """,
                nativeQuery = true
        )*/
    @Query(value = "SELECT c FROM cars c WHERE c.type_car_id=:typeId", nativeQuery = true)
    Page<Car> getCarsByType(@Param("typeId") Long typeId, Pageable pageable);

    @Query(value = "SELECT c FROM Car c")
    Page<Car> getCars(Pageable pageable);

    @Query("SELECT c FROM Car c WHERE c.id = :carId")
    Optional<Car> getCar(@Param("carId") UUID carId);

    @Query(value = "SELECT COUNT(*) FROM Car")
    BigInteger getNumberOfCars();
}
