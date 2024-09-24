package uz.pdp.e_commerce.service.basket;

import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.BasketEntity;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.projection.BasketInfo;

@Service
public interface BasketService {

    BasketInfo save(UserEntity user);


    BasketEntity findById(Long id);

}
