package uz.pdp.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.e_commerce.domain.entity.BasketEntity;
@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

}
