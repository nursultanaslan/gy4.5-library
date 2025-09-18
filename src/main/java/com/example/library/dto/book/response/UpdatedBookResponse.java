package com.example.library.dto.book.response;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;

import java.util.List;

public class UpdatedBookResponse {

    private Integer id;
    private String title;
    private Integer totalPage;
    private String isbn;
    private String imageUrl;

    private Publisher publisher;
    private Category category;

    private List<Author> authors;

    public UpdatedBookResponse() {
    }

    public UpdatedBookResponse(Integer id, String title, Integer totalPage, String isbn, String imageUrl, Publisher publisher, Category category, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.totalPage = totalPage;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.category = category;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
