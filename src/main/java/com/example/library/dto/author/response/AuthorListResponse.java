package com.example.library.dto.author.response;

public class AuthorListResponse {

    private String fullName;

    public AuthorListResponse() {
    }

    public AuthorListResponse(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
