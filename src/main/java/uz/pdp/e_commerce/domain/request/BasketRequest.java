package uz.pdp.e_commerce.domain.request;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BasketRequest {

    private UUID userId;
}
