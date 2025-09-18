package com.example.library.entity;

import com.example.library.entity.enums.BookStatus;
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

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @OneToMany(mappedBy = "bookItems")
    private List<Loan> loans;


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

    public List<Loan> getBorrows() {
        return loans;
    }

    public void setBorrows(List<Loan> loans) {
        this.loans = loans;
    }
}
