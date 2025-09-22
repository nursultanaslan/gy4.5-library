package com.example.library.service;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.dto.user.request.LoginRequest;
import com.example.library.dto.user.request.RegisterRequest;
import com.example.library.dto.user.response.LoginResponse;
import com.example.library.dto.user.response.RegisterResponse;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(@Valid RegisterRequest request){

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        //Sifreyi kaydederken bu sekilde açık metin (plain-text) olarak kaydedemem
        //passwordEncoder ile (and with bcrypt) şifrelendi
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setUsername(user.getUsername());

        return response;

    }

    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new BusinessException("Wrong username or password."));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new BusinessException("Wrong username or password.");
        }

        LoginResponse response = new LoginResponse();
        response.setToken("2727");

        return response;

    }
}
