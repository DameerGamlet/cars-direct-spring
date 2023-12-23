package car.direct.sellerservice.config;

import car.direct.sellerservice.mapper.SellerMapper;
import car.direct.sellerservice.mapper.SellerMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Bean
    @Primary
    public SellerMapper mapper() {
        return new SellerMapperImpl();
    }
}