package cars.direct.controller.public_api;


import car.direct.model.ErrorResponse;
import cars.direct.dto.response.CarResponse;
import cars.direct.model.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Tag(name = "cars")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid data provided to the server", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "401", description = "Authorization error"),
        @ApiResponse(responseCode = "403", description = "It is forbidden to receive a resource"),
        @ApiResponse(responseCode = "404", description = "The car with this ID was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        })
})
public interface CarsApi {

    @Operation(
            summary = "Get all cars",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of cars",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)
                            )
                    }
            )
    )
    Page<CarResponse> getCars(Pageable pageable);

    @Operation(
            summary = "Get cars by brand",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of cars by brand",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)
                            )
                    }
            )
    )
    Page<CarResponse> getCarsByBrand(
            @Parameter(name = "brandId", description = "Brand ID", required = true) Long brandId,
            Pageable pageable
    );

    @Operation(
            summary = "Get cars by brand and model",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of cars by brand and model",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)
                            )
                    }
            )
    )
    Page<CarResponse> getCarsByBrandAndModel(
            @Parameter(name = "brandId", description = "Brand ID", required = true) Long brandId,
            @Parameter(name = "modelId", description = "Model ID", required = true) Long modelId,
            Pageable pageable
    );

    @Operation(
            summary = "Get cars by type",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of cars by type",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)
                            )
                    }
            )
    )
    Page<CarResponse> getCarsByType(
            @Parameter(name = "typeId", description = "Type ID", required = true) Long typeId,
            Pageable pageable
    );

    @Operation(
            summary = "Get car by ID",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of car by ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Car.class)
                            )
                    }
            )
    )
    Car getCarById(
            @Parameter(name = "carId", description = "Car ID", required = true) UUID carId
    );

    @Operation(
            summary = "Get number of cars",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of number of cars",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Long.class)
                            )
                    }
            )
    )
    Long getNumbersOfCars();
}