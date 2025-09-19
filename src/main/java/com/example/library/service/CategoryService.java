package com.example.library.service;

import com.example.library.dto.category.request.CreateCategoryRequest;
import com.example.library.dto.category.request.UpdateCategoryRequest;
import com.example.library.dto.category.response.*;
import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreatedCategoryResponse add(CreateCategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);

        return new CreatedCategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    public List<CategoryListResponse> getAll(){
        //veritabanındaki categorileri cektim ve bir listeye attım
        List<Category> categoryList = categoryRepository.findAll();
        //Dto'ya ait listeyi oluşturdum
        List<CategoryListResponse> categoryListResponses = new ArrayList<>();
        for (Category category: categoryList){
            //categori listesindeki her kategori için bir dto nesnesi oluşturdum
            CategoryListResponse categoryResponse = new CategoryListResponse();
            //gerekli alanları dto'ya set ettim
            categoryResponse.setName(category.getName());
            //ve bu dtoyu dto'ların olacagı listeye ekledim (categorylistresponses)
            categoryListResponses.add(categoryResponse);
        }
        //DTO listesini return ettim.
        return categoryListResponses;
    }

    public DeletedCategoryResponse delete(Integer id){
        categoryRepository.deleteById(id);
        return new DeletedCategoryResponse(

        );
    }

    public GetByIdCategoryResponse getCategoryById(int id){
        //Bussines Rules olacak
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili kategori bulunamadı."));

        //Mapper olacak
        return new GetByIdCategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    public UpdatedCategoryResponse updateCategory(UpdateCategoryRequest updateRequest){
        final Integer id = updateRequest.getId();
        final Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili kategori bulunamadı!"));

        category.setName(updateRequest.getName());
        categoryRepository.save(category);
        return new UpdatedCategoryResponse(
                category.getId(),
                category.getName()
        );
    }

}
