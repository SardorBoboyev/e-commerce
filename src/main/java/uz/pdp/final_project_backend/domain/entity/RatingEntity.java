package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "ratings")
public class RatingEntity extends BaseEntity {
    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private UserEntity user;

    private int rating;
}
