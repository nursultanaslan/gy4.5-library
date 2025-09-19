package com.example.library.rules;

import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category categoryShouldExistWithGivenId(int id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili kategori bulunamadı"));
    }


    public void categoryShouldNotExistWithSameName(String name){
        Category category = categoryRepository.findTop1ByNameIgnoreCase(name)
                .orElse(null);

        if(category != null){
            throw new RuntimeException("Bu isimde bir kategori zaten bulunmakta.");
        }
    }

}
