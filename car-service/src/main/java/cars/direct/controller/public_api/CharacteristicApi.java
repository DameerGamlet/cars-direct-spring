package cars.direct.controller.public_api;

import car.direct.model.ErrorResponse;
import cars.direct.model.BrandCar;
import cars.direct.model.ModelCar;
import cars.direct.model.TypeCar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "characteristics")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid data provided to the server", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        })
})
public interface CharacteristicApi {

    @Operation(
            summary = "Get all brands",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of brands",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class)
                            )
                    }
            )
    )
    List<BrandCar> getAllBrands();

    @Operation(
            summary = "Get models by brand",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of models by brand",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class)
                            )
                    }
            )
    )
    List<ModelCar> getModelsByBrand(
            @Parameter(name = "brandId", description = "Brand ID", required = true) Long brandId
    );

    @Operation(
            summary = "Get types",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Successful retrieval of types",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class)
                            )
                    }
            )
    )
    List<TypeCar> getTypes();
}
