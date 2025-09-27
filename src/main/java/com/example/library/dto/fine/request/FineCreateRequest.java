package com.example.library.dto.fine.request;

import com.example.library.entity.Loan;

import java.time.LocalDate;

public class FineCreateRequest {
    private int fineAmount;
    private LocalDate fineDate;
    private Boolean isPaid;


}
