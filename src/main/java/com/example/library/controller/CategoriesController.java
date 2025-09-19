package com.example.library.controller;

import com.example.library.dto.category.request.CreateCategoryRequest;
import com.example.library.dto.category.request.UpdateCategoryRequest;
import com.example.library.dto.category.response.CategoryListResponse;
import com.example.library.dto.category.response.CreatedCategoryResponse;
import com.example.library.dto.category.response.GetByIdCategoryResponse;
import com.example.library.dto.category.response.UpdatedCategoryResponse;
import com.example.library.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCategoryResponse add(@RequestBody CreateCategoryRequest categoryRequest){
        return categoryService.add(categoryRequest);
    }

    @GetMapping()
    public List<CategoryListResponse> getAll(){
        return categoryService.getAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        categoryService.delete(id);
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping()
    public UpdatedCategoryResponse updateCategory(@RequestBody UpdateCategoryRequest updateRequest){
        return categoryService.updateCategory(updateRequest);
    }
}
