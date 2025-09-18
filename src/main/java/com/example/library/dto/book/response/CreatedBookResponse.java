package com.example.library.dto.book.response;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import com.example.library.entity.enums.BookStatus;

import java.util.List;

public class CreatedBookResponse {
    //Kitap oluşturulduktan sonra neleri cevap olarak dönecegiz?

    private String title;
    private Integer totalPage;

    private BookStatus bookStatus;
    private Publisher publisher;
    private Category category;

    private List<Author> authors;

    public CreatedBookResponse() {
    }

    public CreatedBookResponse(String title,
                               Integer totalPage,
                               BookStatus bookStatus,
                               Publisher publisher, Category category, List<Author> authors) {
        this.title = title;
        this.totalPage = totalPage;
        this.bookStatus = bookStatus;
        this.publisher = publisher;
        this.category = category;
        this.authors = authors;
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

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
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