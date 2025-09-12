package com.example.library.dto.category.request;

public class CreateCategoryRequest {
//Veritabanına bir categori eklerken kullanıcıdan neler talep edecegim?
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
