package com.example.library.rules;

import com.example.library.entity.enums.LoanStatus;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class LoanBusinessRules {

    private final LoanRepository loanRepository;

    public LoanBusinessRules(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void checkBookIsReturned(int memberId, int bookId){
        boolean exists = loanRepository.existsByMemberIdAndBookItemIdAndLoanStatus(memberId, bookId, LoanStatus.OPEN);

        if (exists){
            throw new RuntimeException("Üye bu kitabı zaten ödünç almıştır ve hala iade etmemiştir. " +
                    "İade edilmden yeni bir ödünç kaydı oluşturulamaz");
        }
    }


}
