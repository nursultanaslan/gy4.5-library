package com.example.library.rules;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.entity.Member;
import com.example.library.entity.enums.LoanStatus;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.entity.enums.MembershipLevel;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;


@Component
public class MemberBusinessRules {
    //Business Ruleslar entitye özeldir ve kendi entitysine ait repositoryi entegre ederler
    //Ve kuralları kendi içlerinde yazarlar
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;


    public MemberBusinessRules(MemberRepository memberRepository,
                               LoanRepository loanRepository) {
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    public Member memberShouldExistWithGivenId(int id){
        return memberRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili bir üye bulunamadı!"));
    }


    //email benzersiz olmalı kuralı yaz
    public void emailShouldBeUnique(String email){
        Member member = memberRepository.findByEmail(email);
        if (member != null){
            throw new BusinessException("Bu email ile kayıt oluşturulmuş. Giriş yapmayı deneyin.");
        }
    }


    //MemberStatusu= BANNED olan üyeler rezervasyon / ödünç yapamaz.
    public void checkMemberStatus(MemberStatus memberStatus){
        if(memberStatus.equals(MemberStatus.BANNED)){
            throw new BusinessException("BANNED üyeler ödünç veya rezervasyon yapamaz");
        }
    }


    //MembershipLeveli = STANDARD olan üyeler aktif ödünç kaydı MAX=3 olabilir. GOLD için MAX=5.
    public void checkMaxLoanLimit(Member member){
        long openLoanCount = loanRepository.countByMemberIdAndLoanStatus(member.getId(), LoanStatus.OPEN);
        if (member.getMembershipLevel() == MembershipLevel.STANDARD){
            if (openLoanCount > 3){
                throw new BusinessException("Standart üyelerin en fazla 3 açık kaydı olabilir");
            }
        } else if (member.getMembershipLevel() == MembershipLevel.GOLD) {
            if (openLoanCount > 5){
                throw new BusinessException("Gold üyelerin en fazla 5 aktif ödünç kaydı olabilir");
            }
        }
    }


}
