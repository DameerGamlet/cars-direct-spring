package cars.direct.repository;

import cars.direct.model.TypeCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeCarRepository extends JpaRepository<TypeCar, Long> {

    @Query("SELECT t FROM TypeCar t")
    List<TypeCar> getTypes();
}
