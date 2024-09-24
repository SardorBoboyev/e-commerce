package uz.pdp.e_commerce.service.product;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.ProductEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.ProductInfo;
import uz.pdp.e_commerce.domain.request.ProductRequest;
import uz.pdp.e_commerce.repository.ProductRepository;
import uz.pdp.e_commerce.repository.UserRepository;
import uz.pdp.e_commerce.service.category.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductService productService;


    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;


    @Override
    public ProductInfo save(ProductRequest productReq) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(productReq.getName())
                .price(productReq.getPrice())
                .description(productReq.getDescription())
                .category(categoryService.findById(productReq.getCategoryId()))
                .imagePath(productReq.getImagePath())
                .build();
        ProductEntity savedProduct = productRepository.save(productEntity);
        return modelMapper.map(savedProduct, ProductInfo.class);
    }


    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new BaseException("Product not found with id: " + id));
    }

    @Override
    public List<ProductInfo> findAll() {
        return productRepository.findAllBy();
    }

    @Override
    public ProductInfo update(Long id, ProductRequest productReq) {
        ProductEntity existsProduct = findById(id);
        if (existsProduct == null) {
            throw new BaseException("Product not found with id: " + id);
        }
        existsProduct.setName(productReq.getName());
        existsProduct.setPrice(productReq.getPrice());
        existsProduct.setDescription(productReq.getDescription());
        existsProduct.setCategory(categoryService.findById(productReq.getCategoryId()));
        existsProduct.setImagePath(productReq.getImagePath());

        productRepository.save(existsProduct);

        return modelMapper.map(existsProduct, ProductInfo.class);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductInfo> search(String text) {
        return productService.search(text);
    }

}
