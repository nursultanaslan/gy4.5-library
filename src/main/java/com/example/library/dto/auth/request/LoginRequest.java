package com.example.library.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank
    @Size(min = 4, max = 15, message = "Username length must be 4-9 characters")
    private String username;
    @NotBlank
    @Size(min = 6, max = 20, message = "Password length must be 4-9 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
