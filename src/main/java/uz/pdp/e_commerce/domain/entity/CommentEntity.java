package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(name = "comments")
public class CommentEntity extends BasketEntity {
    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private UserEntity user;

    private String comment;
}
