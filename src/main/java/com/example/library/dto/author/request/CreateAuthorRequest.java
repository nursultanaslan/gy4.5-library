package com.example.library.dto.author.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuthorRequest {
    @NotBlank
    @Size(min = 8, max = 50)
    private String fullName;

    @Size(min = 10, max = 255)
    private String bio;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
