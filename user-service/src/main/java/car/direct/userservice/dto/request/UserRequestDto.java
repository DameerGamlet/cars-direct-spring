package car.direct.userservice.dto.request;

public record UserRequestDto(
        String firstName,
        String lastName,
        String phone,
        String email,
        String sex,
        String photoId
) {
}