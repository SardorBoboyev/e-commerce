package uz.pdp.e_commerce.domain.projection;

import uz.pdp.e_commerce.domain.entity.ProductEntity;

import java.time.LocalDateTime;

/**
 * Projection for {@link uz.pdp.e_commerce.domain.entity.BasketItemEntity}
 */
public interface BasketItemInfo {
    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    Integer getQuantity();

    ProductEntity getProduct();
}