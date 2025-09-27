package com.example.library.dto.book.response;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import com.example.library.entity.enums.BookStatus;


public class GetListBookResponse {
    private Integer id;
    private String title;
    private Integer totalPage;
    private String isbn;
    private String imageUrl;
    private BookStatus bookStatus;
    private Publisher publisher;
    private Category category;
    private Author author;

    public GetListBookResponse() {
    }

    public GetListBookResponse(Integer id, String title, Integer totalPage, String isbn, String imageUrl, BookStatus bookStatus, Publisher publisher, Category category, Author author) {
        this.id = id;
        this.title = title;
        this.totalPage = totalPage;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.bookStatus = bookStatus;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
