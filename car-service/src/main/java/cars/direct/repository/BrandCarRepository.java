package cars.direct.repository;

import cars.direct.model.BrandCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCarRepository extends JpaRepository<BrandCar, Long> {

    @Query("SELECT b FROM BrandCar b")
    List<BrandCar> getBrands();
}
