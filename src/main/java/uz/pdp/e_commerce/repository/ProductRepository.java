package uz.pdp.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.e_commerce.domain.entity.ProductEntity;
import uz.pdp.e_commerce.domain.projection.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
