package uz.pdp.e_commerce.domain.request;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.e_commerce.domain.entity.BasketEntity;
import uz.pdp.e_commerce.domain.entity.ProductEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BasketItemRequest {

    private Long productId;

    private Long basketId;

    private Integer quantity;
}
