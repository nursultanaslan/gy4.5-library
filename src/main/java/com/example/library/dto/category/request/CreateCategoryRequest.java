package com.example.library.dto.category.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCategoryRequest {
//Veritabanına bir categori eklerken kullanıcıdan neler talep edecegim?

    @NotBlank
    @Size(min = 5, max = 25)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
