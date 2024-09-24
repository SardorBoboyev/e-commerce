package uz.pdp.e_commerce.domain.request;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.e_commerce.domain.entity.CategoryEntity;
import uz.pdp.e_commerce.domain.entity.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {
    private String name;

    private String description;

    private Long categoryId;

    private Long userId;

    private Double price;

    private String imagePath;
}
