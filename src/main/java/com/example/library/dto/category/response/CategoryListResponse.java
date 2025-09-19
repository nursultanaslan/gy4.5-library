package com.example.library.dto.category.response;

public class CategoryListResponse {

    private String name;

    public CategoryListResponse() {
    }

    public CategoryListResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
