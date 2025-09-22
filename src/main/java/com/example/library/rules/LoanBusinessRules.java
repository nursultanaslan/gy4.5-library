package com.example.library.rules;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.entity.enums.LoanStatus;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class LoanBusinessRules {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    public LoanBusinessRules(LoanRepository loanRepository,
                             MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public void checkBookIsReturned(int memberId, int bookId){
        boolean exists = loanRepository.existsByMemberIdAndBookItemIdAndLoanStatus(memberId, bookId, LoanStatus.OPEN);

        if (exists){
            throw new BusinessException("Üye bu kitabı zaten ödünç almıştır ve hala iade etmemiştir. " +
                    "İade edilmden yeni bir ödünç kaydı oluşturulamaz");
        }
    }

    public LocalDate calcDueDate(Member member){
        LocalDate loanDate = LocalDate.now();

        Member member1 = memberRepository.findByMembershipLevel(member.getMembershipLevel());

        int N = switch (member.getMembershipLevel()) {
            case STANDARD -> 14;
            case GOLD -> 21;
        };

        return loanDate.plusDays(N);
    }

    public Loan loanShouldExist(int loanId){
        return loanRepository.findById(loanId)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili ödünç kaydı bulunamadı"));
    }

//    public double calcFineAmount(LocalDate loanDate, LocalDate returnDate){
//        double fineAmount = 0;
//
//        if(returnDate.isAfter(loanDate)){
//            long daysBetween = ChronoUnit.DAYS.between(loanDate, returnDate);
//            double pay = 5.0;
//            fineAmount = daysBetween * pay;
//        }
//        return fineAmount;
//    }

}
