package uz.pdp.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.e_commerce.domain.entity.CategoryEntity;
import uz.pdp.e_commerce.domain.projection.CategoryInfo;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryInfo> findAllBy();

}
