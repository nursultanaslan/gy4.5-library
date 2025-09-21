package com.example.library.dto.loan.response;

import com.example.library.entity.BookItem;
import com.example.library.entity.enums.LoanStatus;

import java.time.LocalDate;

public class LoanResponse {
    private Integer id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus loanStatus;
    private BookItem bookItems;

    public LoanResponse() {
    }

    public LoanResponse(Integer id, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate, LoanStatus loanStatus, BookItem bookItems) {
        this.id = id;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.bookItems = bookItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public BookItem getBookItems() {
        return bookItems;
    }

    public void setBookItems(BookItem bookItems) {
        this.bookItems = bookItems;
    }
}
