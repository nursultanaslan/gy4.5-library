package com.example.library.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book_items")
public class BookItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "book_id" , nullable = false)
    private Book books;

    @ManyToOne()
    @JoinColumn(name = "book_status_id", nullable = false)
    private BookStatus bookStatus;

    @OneToMany(mappedBy = "bookItems")
    private List<Borrow> borrows;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
