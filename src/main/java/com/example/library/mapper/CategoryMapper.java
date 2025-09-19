package com.example.library.mapper;

import com.example.library.dto.category.request.CreateCategoryRequest;
import com.example.library.dto.category.request.UpdateCategoryRequest;
import com.example.library.dto.category.response.*;
import com.example.library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CreateCategoryRequest categoryRequest);

    CreatedCategoryResponse toCreatedCategoryResponse(Category category);

    DeletedCategoryResponse toDeletedCategoryResponse(Category category);

    GetByIdCategoryResponse toGetByIdCategoryResponse(Category category);

    Category toCategory(UpdateCategoryRequest updateRequest);

    UpdatedCategoryResponse toUpdatedCategoryResponse(Category category);

    List<CategoryListResponse> toCategoryListResponse(List<Category> categories);
}
