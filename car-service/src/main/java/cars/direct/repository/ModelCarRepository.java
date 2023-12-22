package cars.direct.repository;

import cars.direct.model.ModelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelCarRepository extends JpaRepository<ModelCar, Long> {


    @Query("SELECT m FROM ModelCar m WHERE m.brandCar.id = :brandId")
    List<ModelCar> getModelsByBrand(@Param("brandId") Long brandId);
}
