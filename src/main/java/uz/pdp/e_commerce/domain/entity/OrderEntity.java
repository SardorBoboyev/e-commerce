package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.e_commerce.domain.enumerators.OrderStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "orders")
public class OrderEntity extends BaseEntity {
    @ManyToOne
    private UserEntity owner;

    private double totalAmount;

    private OrderStatus status;

}
