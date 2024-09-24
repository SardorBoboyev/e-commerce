package uz.pdp.e_commerce.service.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.e_commerce.domain.projection.ProductInfo;
import uz.pdp.e_commerce.domain.request.ProductRequest;

import java.util.List;

public interface ProductService {

    @Query("SELECT p FROM products p JOIN p.user WHERE users .id = :userId")
    List<ProductInfo> findProductsByUserId(@Param("userId") Long userId);

    ProductInfo save(ProductRequest productReq);
    void deleteById(Long id);
}
