package com.example.library.controller;

import com.example.library.dto.loan.request.LoanCreateRequest;
import com.example.library.dto.loan.response.LoanResponse;
import com.example.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse create(@Valid @RequestBody LoanCreateRequest loanRequest){
        return loanService.create(loanRequest);
    }
}
