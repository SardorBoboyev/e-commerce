package uz.pdp.final_project_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.final_project_backend.domain.entity.BasketItemEntity;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItemEntity, Long> {

}
