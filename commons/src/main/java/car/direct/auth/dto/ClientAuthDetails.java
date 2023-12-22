package car.direct.auth.dto;

import java.util.UUID;

public record ClientAuthDetails(
        UUID uuid,
        String email,
        String password,
        String role,
        boolean isActive
) {
}