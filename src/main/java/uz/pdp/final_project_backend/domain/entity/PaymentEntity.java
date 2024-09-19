package uz.pdp.final_project_backend.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.final_project_backend.domain.enumerators.PaymentType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "payments")
public class PaymentEntity extends BaseEntity {

    private PaymentType paymentType;

    private Double amount;

    private Boolean paid;

    @ManyToOne
    private OrderEntity order;
}
