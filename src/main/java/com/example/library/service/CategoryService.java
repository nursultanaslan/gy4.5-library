package com.example.library.service;

import com.example.library.dto.category.request.CreateCategoryRequest;
import com.example.library.dto.category.response.CategoryListResponse;
import com.example.library.dto.category.response.CreatedCategoryResponse;
import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

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

    public void deleteCategoryById(Integer id){
        categoryRepository.deleteById(id);
    }




    /*
    * kategori ekle -> add
    * tüm kategorileri listele -> getAll
    * kategori sil -> delete
    *
    *
    * idye göre kategori getir -> getCategoryById
    * kategori güncelle -> update */
}
