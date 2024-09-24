package uz.pdp.e_commerce.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.e_commerce.domain.enumerators.PaymentType;

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
