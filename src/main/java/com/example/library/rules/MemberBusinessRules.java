package com.example.library.rules;

import com.example.library.entity.Member;
import com.example.library.entity.enums.MembershipLevel;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

//Buradaki methodları farklı classlar da kullanabilsin diye bu şekilde class oluşturuurz
@Component
public class MemberBusinessRules {
    //Business Ruleslar entitye özeldir ve kendi entitysine ait repositoryi entegre ederler
    //Ve kuralları kendi içlerinde yazarlar
    private MemberRepository memberRepository;

    public MemberBusinessRules(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member memberShouldExistWithGivenId(int id){
        return memberRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili bir üye bulunamadı!"));
    }

    //MembershipLeveli = STANDARD olan üyeler aktif ödünç kaydı MAX=3 olabilir. GOLD için MAX=5.
    public void checkMaxLoanLimit(MembershipLevel level){
        Member membershipLevel = memberRepository.findByMembershipLevel(level);

    }

    //MemberStatusu= BANNED olan üyeler rezervasyon / ödünç yapamaz.
    public void checkMemberStatus(){

    }


}
