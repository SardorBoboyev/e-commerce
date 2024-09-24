package uz.pdp.e_commerce.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.e_commerce.domain.projection.CategoryInfo;
import uz.pdp.e_commerce.domain.request.CategoryRequest;
import uz.pdp.e_commerce.service.category.CategoryServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping
    public CategoryInfo create(@RequestBody CategoryRequest category) {
        return categoryService.save(category);
    }

    @GetMapping
    public List<CategoryInfo> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("/id")
    public CategoryInfo update(@RequestParam("id") Long id, @RequestBody CategoryRequest category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/id")
    public void delete(@RequestParam("id") Long id) {
        categoryService.deleteById(id);
    }

}
