package uz.pdp.e_commerce.domain.projection;

import lombok.Builder;
import uz.pdp.e_commerce.domain.enumerators.UserRole;

import java.time.LocalDateTime;

/**
 * Projection for {@link uz.pdp.e_commerce.domain.entity.UserEntity}
 */
public interface UserInfo {
    Long getId();

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    String getFullName();

    String getUsername();

    UserRole getRole();
}