package com.example.library.dto.author.response;

public class CreatedAuthorResponse {
    private String fullName;
    private String bio;

    public CreatedAuthorResponse() {
    }

    public CreatedAuthorResponse(String fullName, String bio) {
        this.fullName = fullName;
        this.bio = bio;
    }

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
