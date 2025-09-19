package com.example.library.dto.fine.response;

import java.time.LocalDate;

public class FineResponse {
    private Integer id;
    private int fineAmount;
    private LocalDate fineDate;
    private Boolean isPaid;

    public FineResponse() {
    }

    public FineResponse(Integer id, int fineAmount, LocalDate fineDate, Boolean isPaid) {
        this.id = id;
        this.fineAmount = fineAmount;
        this.fineDate = fineDate;
        this.isPaid = isPaid;
    }

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
}
