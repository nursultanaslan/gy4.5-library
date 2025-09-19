package com.example.library.dto.fine.request;

import com.example.library.entity.Loan;
import com.example.library.entity.Member;

import java.time.LocalDate;

public class FineCreateRequest {
    private int fineAmount;
    private LocalDate fineDate;
    private Boolean isPaid;

    private Member member;
    private Loan loan;

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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
