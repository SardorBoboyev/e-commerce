package uz.pdp.e_commerce.service.category;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.CategoryEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.CategoryInfo;
import uz.pdp.e_commerce.domain.request.CategoryRequest;
import uz.pdp.e_commerce.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;


    @Override
    public CategoryInfo save(CategoryRequest category) {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .categoryName(category.getCategoryName())
                .build();
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        return modelMapper.map(savedCategory, CategoryInfo.class);
    }

    @Override
    public List<CategoryInfo> getAll() {
        return categoryRepository.findAllBy();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new BaseException("Category not found with id: " + id));
    }


    @Override
    public CategoryInfo update(Long id, CategoryRequest category) {
        CategoryEntity existsCategoryName = findById(id);
        if (existsCategoryName == null) {
            throw new BaseException("Category not found with id: " + id);
        }
        existsCategoryName.setCategoryName(category.getCategoryName());
        categoryRepository.save(existsCategoryName);

        return modelMapper.map(existsCategoryName, CategoryInfo.class);
    }

}




