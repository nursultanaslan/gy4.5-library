package com.example.library.dto.member.response;

import com.example.library.entity.Fine;
import com.example.library.entity.enums.MemberRole;
import com.example.library.entity.enums.MemberStatus;
import com.example.library.entity.enums.MembershipLevel;

import java.util.List;

public class GetByIdMemberResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;

    private MembershipLevel membershipLevel;
    private MemberRole role;
    private MemberStatus memberStatus;
    private List<Fine> fines;

    public GetByIdMemberResponse() {
    }

    public GetByIdMemberResponse(Integer id, String firstName, String lastName, String username, String email, String phone, MembershipLevel membershipLevel, MemberRole role, MemberStatus memberStatus, List<Fine> fines) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.membershipLevel = membershipLevel;
        this.role = role;
        this.memberStatus = memberStatus;
        this.fines = fines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public MemberRole getRole() {
        return role;
    }

    public void setRole(MemberRole role) {
        this.role = role;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }
}
