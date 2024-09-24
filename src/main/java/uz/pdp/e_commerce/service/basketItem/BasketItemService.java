package uz.pdp.e_commerce.service.basketItem;

import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.BasketItemEntity;
import uz.pdp.e_commerce.domain.projection.BasketItemInfo;
import uz.pdp.e_commerce.domain.request.BasketItemRequest;

import java.util.List;

@Service
public interface BasketItemService {

    BasketItemInfo save(BasketItemRequest basketItemRequest);

    BasketItemInfo update(Long id, BasketItemRequest basketItemRequest);

    List<BasketItemInfo> findAll();

    BasketItemEntity findById(Long id);

    void deleteById(Long id);
}
