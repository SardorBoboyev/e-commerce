package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.final_project_backend.domain.enumerators.OrderStatus;

import java.util.List;

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
