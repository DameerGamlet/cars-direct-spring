package car.direct.model;

import java.time.OffsetDateTime;

public record ErrorResponse(String id, String message, OffsetDateTime timestamp) {
}
