package uz.pdp.e_commerce.domain.projection;

import uz.pdp.e_commerce.domain.entity.CategoryEntity;
import uz.pdp.e_commerce.domain.entity.ProductEntity;
import uz.pdp.e_commerce.domain.entity.UserEntity;

import java.time.LocalDateTime;

/**
 * Projection for {@link ProductEntity}
 */
public interface ProductInfo {
    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    String getName();

    String getDescription();

    Double getPrice();

    String getImagePath();

    CategoryEntity getCategory();

}