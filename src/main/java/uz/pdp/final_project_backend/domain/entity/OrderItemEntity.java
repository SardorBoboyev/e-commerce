package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "order-items")
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    private OrderEntity order;

    @ManyToOne
    private ProductEntity product;

    private Integer quantity;
}
