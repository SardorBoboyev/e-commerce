package uz.pdp.e_commerce.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.projection.ProductInfo;
import uz.pdp.e_commerce.domain.request.ProductRequest;
import uz.pdp.e_commerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductInfo> findProductsByUserId(Long userId) {
        return productService.findProductsByUserId(userId);
    }

    @Override
    public ProductInfo save(ProductRequest productReq) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }


}
