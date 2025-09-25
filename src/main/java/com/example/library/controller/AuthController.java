package com.example.library.controller;

import com.example.library.dto.auth.request.LoginRequest;
import com.example.library.dto.auth.request.RegisterRequest;
import com.example.library.dto.auth.response.LoginResponse;
import com.example.library.dto.auth.response.RegisteredResponse;
import com.example.library.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RegisteredResponse register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @GetMapping("verify-token")
    public Boolean validateToken(@RequestParam String token){
        return authService.validateToken(token);
    }
}
