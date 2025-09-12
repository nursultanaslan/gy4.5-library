package com.example.library.dto.category.response;

public class CreatedCategoryResponse {
    //Kategori oluşturulduktan sonra bana response olarak ne dönsün.
    private Integer id;
    private String name;

    public CreatedCategoryResponse() {
    }

    public CreatedCategoryResponse(Integer id, String name) {
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
