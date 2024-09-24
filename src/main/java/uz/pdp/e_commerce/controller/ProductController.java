package uz.pdp.e_commerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.e_commerce.domain.projection.ProductInfo;
import uz.pdp.e_commerce.domain.request.ProductRequest;
import uz.pdp.e_commerce.service.product.ProductService;
import uz.pdp.e_commerce.service.product.ProductServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public ProductInfo save(@RequestBody ProductRequest product) {
        return productService.save(product);
    }

    @GetMapping
    public List<ProductInfo> findAll() {
        return productService.findAll();
    }

    @PutMapping("/id")
    public ProductInfo update(@RequestParam("id") Long id, @RequestBody ProductRequest product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/id")
    public void delete(@RequestParam("id") Long id) {
        productService.deleteById(id);
    }

}
