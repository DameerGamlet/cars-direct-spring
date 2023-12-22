package car.direct.userservice.controller.publicapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import car.direct.model.ErrorResponse;
import car.direct.userservice.dto.request.UserRegistrationDto;
import car.direct.userservice.dto.request.UserRequestDto;
import car.direct.userservice.dto.response.CreateUserResponse;
import car.direct.userservice.dto.response.UserResponseDto;

import java.util.UUID;

@Tag(name = "users")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Недопустимые данные, предоставленные серверу", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "401", description = "Ошибка авторизации"),
        @ApiResponse(responseCode = "403", description = "Запрещено получать ресурс"),
        @ApiResponse(responseCode = "404", description = "Пользователь с данным ID не найден",
                content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                })
})
public interface UserApi {

    @Operation(
            summary = "Регистарция пользователя",
            responses = @ApiResponse(
                    responseCode = "201",
                    description = "Успешное создание пользователя",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreateUserResponse.class)
                            )
                    }
            )
    )
    CreateUserResponse create(
            @Parameter(name = "userRegistrationDto", description = "Регистрация пользователя")
            UserRegistrationDto userRegistrationDto
    );

    @Operation(
            summary = "Получение пользователя по ID",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = @ApiResponse(responseCode = "200", description = "Успешное получение пользователя", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }))
    @PreAuthorize(value = """
            @permissionService.hasPermission(
                #externalId,
                T(car.direct.auth.model.Role).USER,
                T(car.direct.auth.util.ClientAttributes).USER_ID
            )
            """
    )
    UserResponseDto getByExternalId(
            @Parameter(name = "id", description = "ID пользователя", required = true) UUID externalId);


    @Operation(
            summary = "Обновление пользователя",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = @ApiResponse(responseCode = "200", description = "Успешное обновление пользователя", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))
            }))
    @PreAuthorize(value = """
            @permissionService.hasPermission(
                #externalId,
                T(car.direct.auth.model.Role).USER,
                T(car.direct.auth.util.ClientAttributes).USER_ID
            )
            """
    )
    UserResponseDto updateUser(
            @Parameter(name = "id", description = "ID пользователя", required = true) UUID externalId,
            @Parameter(name = "UserRequestDto", description = "Обновить существующего пользователя")
            UserRequestDto userRequestDto);

    @Operation(
            summary = "Удалить пользователя",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = @ApiResponse(responseCode = "204", description = "Успешное удаление")
    )
    @PreAuthorize(value = """
            @permissionService.hasPermission(
                #externalId,
                T(car.direct.auth.model.Role).USER,
                T(car.direct.auth.util.ClientAttributes).USER_ID
            )
            """
    )
    void deleteUser(
            @Parameter(name = "id", description = "ID пользователя", required = true) UUID externalId
    );
}