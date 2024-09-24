package uz.pdp.e_commerce.service.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.e_commerce.domain.entity.ProductEntity;
import uz.pdp.e_commerce.domain.projection.ProductInfo;
import uz.pdp.e_commerce.domain.request.ProductRequest;

import java.util.List;

public interface ProductService {

    ProductInfo save(ProductRequest productReq);

    ProductEntity findById(Long id);

    List<ProductInfo> findAll();

    ProductInfo update(Long id, ProductRequest productReq);

    void deleteById(Long id);

    List<ProductInfo> search(String text);
}
