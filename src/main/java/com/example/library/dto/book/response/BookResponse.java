package com.example.library.dto.book.response;

import com.example.library.entity.*;
import com.example.library.entity.enums.BookStatus;

import java.util.List;

public class BookResponse {

    private Integer id;
    private String title;
    private Integer totalPage;
    private String isbn;
    private String imageUrl;

    private BookStatus bookStatus;

    private Publisher publisher;
    private Category category;

    private List<Author> authors;
    private List<BookItem> bookItems;
    private List<Reservation> reservations;

    private long totalCopies;
    private long availableCopies;

    public BookResponse() {
    }

    public BookResponse(Integer id, String title, Integer totalPage, String isbn, String imageUrl, BookStatus bookStatus, Publisher publisher, Category category, List<Author> authors, List<BookItem> bookItems, List<Reservation> reservations, int totalCopies, int availableCopies) {
        this.id = id;
        this.title = title;
        this.totalPage = totalPage;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.bookStatus = bookStatus;
        this.publisher = publisher;
        this.category = category;
        this.authors = authors;
        this.bookItems = bookItems;
        this.reservations = reservations;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<BookItem> getBookItems() {
        return bookItems;
    }

    public void setBookItems(List<BookItem> bookItems) {
        this.bookItems = bookItems;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public long getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(long totalCopies) {
        this.totalCopies = totalCopies;
    }

    public long getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(long availableCopies) {
        this.availableCopies = availableCopies;
    }
}
