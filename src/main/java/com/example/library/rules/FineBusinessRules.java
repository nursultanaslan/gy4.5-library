package com.example.library.rules;

import com.example.library.core.exception.type.BusinessException;
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
            throw new BusinessException("Kullanıcının ödenmemiş cezası bulunmakta, yeni ödünç alamaz.");
        }
    }
}
