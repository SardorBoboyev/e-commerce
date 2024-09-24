package uz.pdp.e_commerce.service.category;

import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.CategoryEntity;
import uz.pdp.e_commerce.domain.projection.CategoryInfo;
import uz.pdp.e_commerce.domain.request.CategoryRequest;

import java.util.List;

@Service
public interface CategoryService {

    CategoryInfo save(CategoryRequest category);

    List<CategoryInfo> getAll();

    void deleteById(Long id);

    CategoryEntity findById(Long id);

    CategoryInfo update(Long id, CategoryRequest category);
}
