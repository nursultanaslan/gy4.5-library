package com.example.library.service;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.core.jwt.JwtUtil;
import com.example.library.dto.auth.request.LoginRequest;
import com.example.library.dto.auth.request.RegisterRequest;
import com.example.library.dto.auth.response.LoginResponse;
import com.example.library.dto.auth.response.RegisteredResponse;
import com.example.library.entity.User;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.repository.UserRepository;
import com.example.library.rules.UserBusinessRules;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserBusinessRules userBusinessRules;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       UserBusinessRules userBusinessRules) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userBusinessRules = userBusinessRules;
    }

    public RegisteredResponse register(@Valid RegisterRequest request){

        //email-phone-username must be unique
        userBusinessRules.emailShouldBeUnique(request.getEmail());

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        //Sifreyi kaydederken bu sekilde açık metin (plain-text) olarak kaydedemem
        //passwordEncoder ile (and with bcrypt) şifrelendi
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setMemberStatus(MemberStatus.getDefault());

        userRepository.save(user);

        RegisteredResponse response = new RegisteredResponse();
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

        List<String> roles = user
                .getOperationClaims()
                .stream()
                .map(o -> o.getName())
                .toList();

        LoginResponse response = new LoginResponse();
        //login başarılı -> token oluşturulur.
        response.setToken(jwtUtil.generateToken(user.getUsername(), roles));

        return response;

    }

    public Boolean validateToken(String token){
        return jwtUtil.validateToken(token);
    }
}
