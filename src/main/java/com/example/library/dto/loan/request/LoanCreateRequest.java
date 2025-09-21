package com.example.library.dto.loan.request;

import jakarta.validation.constraints.Positive;

public class LoanCreateRequest {

    @Positive
    private Integer bookItemId;
    @Positive
    private Integer memberId;

    public Integer getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(Integer bookItemId) {
        this.bookItemId = bookItemId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
