package car.direct.userservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import car.direct.mapper.Mapper;
import car.direct.userservice.dto.response.UserResponseDto;
import car.direct.userservice.model.User;

@Component
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<User, UserResponseDto> {

    // TODO: исправить
    @Override
    public UserResponseDto map(User user) {
        return new UserResponseDto(
                user.externalId(),
                user.credentials().getFirstName(),
                user.credentials().getLastName(),
                user.credentials().getPhone(),
                user.email(),
                user.photoId()
        );
    }
}