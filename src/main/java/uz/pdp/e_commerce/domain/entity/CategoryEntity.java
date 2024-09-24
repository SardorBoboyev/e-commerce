package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String categoryName;
}
