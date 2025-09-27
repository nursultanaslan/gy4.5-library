package com.example.library.dto.user.response;

public class DeletedUserResponse {

    private Integer id;

    public DeletedUserResponse() {
    }

    public DeletedUserResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
