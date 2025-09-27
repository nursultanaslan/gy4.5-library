package com.example.library.controller;

import com.example.library.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
public class LoansController {

    private final LoanService loanService;

    public LoansController(LoanService loanService) {
        this.loanService = loanService;
    }

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public LoanResponse create(@Valid @RequestBody LoanCreateRequest loanRequest){
//        return loanService.create(loanRequest);
//    }
}
