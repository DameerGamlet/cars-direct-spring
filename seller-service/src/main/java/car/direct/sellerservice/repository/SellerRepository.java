package car.direct.sellerservice.repository;

import car.direct.auth.dto.ClientAuthDetails;
import car.direct.sellerservice.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsSellerByEmail(String email);

    Optional<Seller> findByExternalId(UUID externalId);

    @Query(value = """
        SELECT new car.direct.auth.dto.ClientAuthDetails(s.externalId, s.email, s.password, upper(s.role))
        FROM Seller s
        WHERE s.email = :email AND s.isDeleted = false
        """
    )
    Optional<ClientAuthDetails> findSellerAuthDetailsByEmail(String email);
}