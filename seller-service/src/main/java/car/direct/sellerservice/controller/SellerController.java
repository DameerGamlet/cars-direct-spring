package car.direct.sellerservice.controller;

import car.direct.sellerservice.dto.SellerRegistration;
import car.direct.sellerservice.dto.SellerRequestDto;
import car.direct.sellerservice.dto.SellerResponseDto;
import car.direct.sellerservice.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static car.direct.util.HttpUtils.PUBLIC_API_VI;

@Slf4j
@RestController
//@RequestMapping(PUBLIC_API_V1)
@RequestMapping("public/api/v1")
@RequiredArgsConstructor
public class SellerController implements SellerApi {

    private final SellerService sellerService;

    @PostMapping("sellers")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createSeller(@RequestBody @Valid SellerRegistration sellerRegistration) {
        return sellerService.createSeller(sellerRegistration);
    }

    @GetMapping("sellers/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public SellerResponseDto getSellerBySellerId(
            @PathVariable("sellerId") UUID sellerId) {
        return sellerService.getSellerBySellerId(sellerId);
    }

    @PutMapping("sellers/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public SellerResponseDto updateSeller(
            @PathVariable UUID sellerId,
            @RequestBody @Valid SellerRequestDto sellerRequestDto) {
        return sellerService.updateSeller(sellerId, sellerRequestDto);
    }

    @DeleteMapping("sellers/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeller(@PathVariable UUID sellerId) {
        sellerService.deleteSellerBySellerId(sellerId);
    }
}