package car.direct.userservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import car.direct.mapper.Mapper;
import car.direct.userservice.dto.request.UserRequestDto;
import car.direct.userservice.model.User;
import car.direct.userservice.model.UserMailRequest;

import java.util.UUID;

// TODO: Исправить в будущем
@Component
@RequiredArgsConstructor
public class UserRequestMapper implements Mapper<UserRequestDto, User> {


    @Override
    public User map(UserRequestDto userRequestDto) {
        return null;
//        return new User()
//                .externalId(UUID.randomUUID())
//                .firstName(userRequestDto.firstName())
//                .lastName(userRequestDto.lastName())
//                .phone(userRequestDto.phone())
//                .email(userRequestDto.email())
//                .login(trimEmailForLogin(userRequestDto))
//                .photoId(userRequestDto.photoId());
    }

    public UserMailRequest toMailRequest(User user) {
        return UserMailRequest.builder()
                .externalId(UUID.randomUUID())
                .firstName(user.credentials().getFirstName())
                .lastName(user.credentials().getLastName())
                .email(user.email())
                .isActive(user.isActive())
                .build();
    }

    private String trimEmailForLogin(UserRequestDto userRequestDto) {
        return userRequestDto.email().replaceAll("@[a-zA-Z0-9.-]+$", "");
    }
}