package com.example.library.rules;

import com.example.library.repository.FineRepository;
import org.springframework.stereotype.Component;

@Component
public class FineBusinessRules {

    private final FineRepository fineRepository;

    public FineBusinessRules(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    public void checkFineIsPaid(int memberId){

        boolean exists = fineRepository.existsByMemberIdAndIsPaidIsFalse(memberId);
        if (exists){
            throw new RuntimeException("Kullanıcının ödenmemiş cezası bulunmakta, yeni ödünç alamaz.");
        }
    }
}
