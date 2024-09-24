package uz.pdp.e_commerce.domain.projection;

import uz.pdp.e_commerce.domain.entity.CategoryEntity;

import java.time.LocalDateTime;

/**
 * Projection for {@link CategoryEntity}
 */
public interface CategoryInfo {
    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    String getCategoryName();
}