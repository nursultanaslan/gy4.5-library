package com.example.library.rules;

import com.example.library.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
