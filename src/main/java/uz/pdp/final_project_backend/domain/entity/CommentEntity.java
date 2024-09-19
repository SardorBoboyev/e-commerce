package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "users")
public class CommentEntity extends BasketEntity {
    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private UserEntity user;

    private String comment;
}
