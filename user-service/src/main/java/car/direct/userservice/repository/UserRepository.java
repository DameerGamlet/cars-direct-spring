package car.direct.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import car.direct.auth.dto.ClientAuthDetails;
import car.direct.userservice.model.User;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN COUNT(u) = 1 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean existsByEmail(String email);

    @Query("FROM User u WHERE u.externalId = :externalId AND u.isDeleted = false")
    Optional<User> findByExternalId(@Param("externalId") UUID externalId);

    @Query(value = """
        SELECT new car.direct.auth.dto.ClientAuthDetails(u.externalId, u.email, u.password, upper(u.role), u.isActive)
        FROM User u
        WHERE u.email = :email AND u.isDeleted = false
        """
    )
    Optional<ClientAuthDetails> findUserByEmail(String email);

    @Modifying
    @Query("""
            DELETE FROM User u
            WHERE u.createdAt < :dateTime
            """)
    void deleteByCreatedAtBefore(@Param("dateTime") LocalDateTime dateTime);
}