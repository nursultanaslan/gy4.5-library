package com.example.library.dto.category.response;

//güncellemeden sonra dönecek response.
public class UpdatedCategoryResponse {
    private Integer id;
    private String name;

    public UpdatedCategoryResponse() {
    }

    public UpdatedCategoryResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
