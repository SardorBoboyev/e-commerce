package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "basket-items")
public class BasketItemEntity extends BaseEntity {

    @OneToOne
    private ProductEntity product;

    @ManyToOne
    private BasketEntity basket;

    private Integer quantity;
}
