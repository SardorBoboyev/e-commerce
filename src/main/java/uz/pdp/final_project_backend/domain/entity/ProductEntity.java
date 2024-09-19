package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "products")
public class ProductEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private CategoryEntity category;

    private Double price;

    private String imagePath;
}
