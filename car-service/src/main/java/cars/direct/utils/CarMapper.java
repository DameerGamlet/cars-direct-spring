package cars.direct.utils;

import cars.direct.dto.request.CarRequest;
import cars.direct.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Car mapToCar(CarRequest request);
}
