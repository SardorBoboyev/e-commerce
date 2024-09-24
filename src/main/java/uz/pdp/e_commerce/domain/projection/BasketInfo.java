package uz.pdp.e_commerce.domain.projection;

import uz.pdp.e_commerce.domain.entity.BasketEntity;
import uz.pdp.e_commerce.domain.entity.UserEntity;

import java.time.LocalDateTime;

/**
 * Projection for {@link BasketEntity}
 */
public interface BasketInfo {
    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    UserEntity getUser();
}