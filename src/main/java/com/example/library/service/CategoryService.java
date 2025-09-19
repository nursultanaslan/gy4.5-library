package com.example.library.service;

import com.example.library.dto.category.request.CreateCategoryRequest;
import com.example.library.dto.category.request.UpdateCategoryRequest;
import com.example.library.dto.category.response.*;
import com.example.library.entity.Category;
import com.example.library.mapper.CategoryMapper;
import com.example.library.repository.CategoryRepository;
import com.example.library.rules.CategoryBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryBusinessRules categoryBusinessRules,
                           CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.categoryMapper = CategoryMapper.INSTANCE;
    }

    public CreatedCategoryResponse add(@Valid CreateCategoryRequest request){
        categoryBusinessRules.categoryShouldNotExistWithSameName(request.getName());
        Category category = categoryMapper.toCategory(request);
        category = categoryRepository.save(category);

        return categoryMapper.toCreatedCategoryResponse(category);
    }

    public List<CategoryListResponse> getAll(){
        //veritabanındaki categorileri cektim ve bir listeye attım
        List<Category> categoryList = categoryRepository.findAll();

        return categoryMapper.toCategoryListResponse(categoryList);

    }

    public DeletedCategoryResponse delete(Integer id){
        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);
        categoryRepository.delete(category);
        return categoryMapper.toDeletedCategoryResponse(category);
    }

    public GetByIdCategoryResponse getCategoryById(int id){

        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(id);
        return categoryMapper.toGetByIdCategoryResponse(category);
    }

    public UpdatedCategoryResponse updateCategory(@Valid UpdateCategoryRequest updateRequest){

        Category category = categoryBusinessRules.categoryShouldExistWithGivenId(updateRequest.getId());
        categoryBusinessRules.categoryShouldNotExistWithSameName(updateRequest.getName());
        category = categoryMapper.toCategory(updateRequest);
        category = categoryRepository.save(category);

        return categoryMapper.toUpdatedCategoryResponse(category);
    }

}
