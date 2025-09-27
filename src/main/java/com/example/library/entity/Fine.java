package com.example.library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fine_amount")
    private int fineAmount;
    @Column(name = "fine_date")
    private LocalDate fineDate;
    @Column(name = "is_paid")
    private Boolean isPaid;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne()
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public LocalDate getFineDate() {
        return fineDate;
    }

    public void setFineDate(LocalDate fineDate) {
        this.fineDate = fineDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
