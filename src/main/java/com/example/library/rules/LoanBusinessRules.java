package com.example.library.rules;

import com.example.library.entity.Member;
import com.example.library.entity.enums.LoanStatus;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
            throw new RuntimeException("Üye bu kitabı zaten ödünç almıştır ve hala iade etmemiştir. " +
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

}
