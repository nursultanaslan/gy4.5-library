package com.example.library.dto.category.response;

//güncellemeden sonra dönecek response.
public class UpdatedCategoryResponse {

    private String name;

    public UpdatedCategoryResponse() {
    }

    public UpdatedCategoryResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
