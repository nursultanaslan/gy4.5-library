package com.example.library.entity;

import com.example.library.entity.enums.LoanStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loan_date")
    private LocalDate loanDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "loan_status")
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    @ManyToOne
    @JoinColumn(name = "book_item_id", nullable = false)
    private BookItem bookItems;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToOne(mappedBy = "loan")
    private Fine fine;

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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }
}
