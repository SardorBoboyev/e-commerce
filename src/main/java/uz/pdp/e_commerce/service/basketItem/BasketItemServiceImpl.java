package uz.pdp.e_commerce.service.basketItem;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.BasketItemEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.BasketItemInfo;
import uz.pdp.e_commerce.domain.request.BasketItemRequest;
import uz.pdp.e_commerce.repository.BasketItemRepository;
import uz.pdp.e_commerce.service.basket.BasketServiceImpl;
import uz.pdp.e_commerce.service.product.ProductServiceImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketServiceImpl basketServiceImpl;
    private final ProductServiceImpl productServiceImpl;
    private final BasketItemRepository basketItemRepository;
    private final ModelMapper modelMapper;

    @Override
    public BasketItemInfo save(BasketItemRequest basketItemRequest) {
        BasketItemEntity basketItemEntity = BasketItemEntity.builder()
                .basket(basketServiceImpl.findById(basketItemRequest.getBasketId()))
                .product(productServiceImpl.findById(basketItemRequest.getProductId()))
                .quantity(basketItemRequest.getQuantity())
                .build();
        BasketItemEntity saved = basketItemRepository.save(basketItemEntity);
        return modelMapper.map(saved, BasketItemInfo.class);
    }

    @Override
    public BasketItemInfo update(Long id, BasketItemRequest basketItemRequest) {
        BasketItemEntity existsBasketItem = findById(id);
        if (existsBasketItem == null) {
            throw new BaseException("Basket item not found");
        }
        existsBasketItem.setQuantity(basketItemRequest.getQuantity());
        existsBasketItem.setBasket(basketServiceImpl.findById(basketItemRequest.getBasketId()));
        existsBasketItem.setProduct(productServiceImpl.findById(basketItemRequest.getProductId()));
        BasketItemEntity saved = basketItemRepository.save(existsBasketItem);
        return modelMapper.map(saved, BasketItemInfo.class);
    }

    @Override
    public List<BasketItemInfo> findAll() {
        return basketItemRepository.findAllBy();
    }

    @Override
    public BasketItemEntity findById(Long id) {
        return basketItemRepository.findById(id).orElseThrow(() -> new BaseException("Basket Item Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        basketItemRepository.deleteById(id);
    }
}
