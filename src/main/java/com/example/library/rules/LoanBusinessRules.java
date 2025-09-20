package com.example.library.rules;

import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class LoanBusinessRules {

    private final LoanRepository loanRepository;

    public LoanBusinessRules(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


}
