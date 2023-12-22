package car.direct.sellerservice.service;
import car.direct.sellerservice.dto.SellerRegistration;
import car.direct.sellerservice.dto.SellerRequestDto;
import car.direct.sellerservice.dto.SellerResponseDto;
import car.direct.sellerservice.mapper.SellerMapper;
import car.direct.sellerservice.model.Seller;
import car.direct.sellerservice.repository.SellerRepository;
import car.direct.auth.dto.ClientAuthDetails;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    private final SellerMapper sellerMapper;

    private static final String SELLER_NOT_FOUND_EXCEPTION = "Seller not found with seller id = ";

    @Transactional
    public UUID createSeller(SellerRegistration sellerRegistration) {
        if (sellerRepository.existsSellerByEmail(sellerRegistration.email())) {
            throw new EntityExistsException("Seller with email " + sellerRegistration.email() + " already exist");
        }

        Seller seller = sellerMapper.toSeller(sellerRegistration);
        return sellerRepository.save(seller).getExternalId();
    }

    public SellerResponseDto getSellerBySellerId(UUID sellerId) {
        return sellerMapper.toSellerResponseDto(sellerRepository
                .findByExternalId(sellerId)
                .orElseThrow(() -> new EntityNotFoundException(SELLER_NOT_FOUND_EXCEPTION + sellerId)));
    }

    @Transactional
    public ClientAuthDetails getSellerAuthDetails(String email) {
        return sellerRepository.findSellerAuthDetailsByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("No seller with email " + email));
    }

    @Transactional
    public SellerResponseDto updateSeller(UUID sellerId, SellerRequestDto sellerRequestDto) {
        Seller seller = sellerRepository
                .findByExternalId(sellerId)
                .orElseThrow(() -> new EntityNotFoundException(SELLER_NOT_FOUND_EXCEPTION + sellerId));
        sellerMapper.updateSellerModel(sellerRequestDto, seller);
        return sellerMapper.toSellerResponseDto(seller);
    }

    @Transactional
    public void deleteSellerBySellerId(UUID sellerId) {
        Seller seller = sellerRepository
                .findByExternalId(sellerId)
                .orElseThrow(() -> new EntityNotFoundException(SELLER_NOT_FOUND_EXCEPTION + sellerId));
        sellerRepository.deleteById(seller.getId());
    }
}