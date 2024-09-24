package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "categories")
public class CategoryEntity extends BaseEntity {
    private String categoryName;
}
