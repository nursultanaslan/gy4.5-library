package com.example.library.rules;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class UserBusinessRules {

    private final UserRepository userRepository;

    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userShouldExistWithGivenId(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili bir kullanıcı bulunamadı!"));
    }

    //email-phone-username unique olmalı
    public void emailShouldBeUnique(String email){
        User user = userRepository.findByEmail(email)
                .orElse(null);
        if (user != null){
            throw new BusinessException("Bu email ile kayıt oluşturulmuş. Giriş yapmayı deneyin!");
        }
    }

    public void usernameMustBeUnique(String username){
        User user = userRepository.findByUsername(username)
                .orElse(null);
        if (user != null){
            throw new BusinessException("Bu kullanıcı adı kullanılamaz. Başka bir kullanıcı adı seçin.");
        }
    }

    public void phoneMustBeUnique(String phone){
        User user = userRepository.findByPhone(phone)
                .orElse(null);
        if (user != null){
            throw new BusinessException("Bu kullanıcı telefon numarası kayıtlı, kullanılamaz.");
        }
    }

//    public Boolean phoneMustBeUnique1(String phone){
//          return userRepository.existsByPhone(phone);
//    }

}
