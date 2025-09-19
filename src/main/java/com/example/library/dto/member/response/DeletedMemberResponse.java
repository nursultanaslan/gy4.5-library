package com.example.library.dto.member.response;

public class DeletedMemberResponse {

    private Integer id;

    public DeletedMemberResponse() {
    }

    public DeletedMemberResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
