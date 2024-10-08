package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "baskets")
public class BasketEntity extends BaseEntity {
    @OneToOne
    private UserEntity user;

}
