package com.example.library.dto.loan.request;

import jakarta.validation.constraints.Positive;

public class LoanReturnRequest {
    @Positive
    private Integer loanId;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
}
