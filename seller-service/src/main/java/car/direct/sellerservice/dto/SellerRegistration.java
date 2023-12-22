package car.direct.sellerservice.dto;

import car.direct.sellerservice.validator.annotation.SellerEmailConstraint;
import car.direct.sellerservice.validator.annotation.SellerPasswordConstraint;
public record SellerRegistration(
        @SellerEmailConstraint
        String email,
        @SellerPasswordConstraint
        String password
) {
}