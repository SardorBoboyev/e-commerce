package uz.pdp.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.e_commerce.domain.entity.BasketItemEntity;
import uz.pdp.e_commerce.domain.projection.BasketItemInfo;
import uz.pdp.e_commerce.domain.request.BasketItemRequest;

import java.util.List;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItemEntity, Long> {

    List<BasketItemInfo> findAllBy();
}
