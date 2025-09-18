package com.example.library.dto.member.response;

import com.example.library.entity.Loan;
import com.example.library.entity.Fine;

import java.util.List;

public class MemberResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private List<Loan> loans;
    private List<Fine> fines;

    public MemberResponse() {
    }

    public MemberResponse(Integer id, String firstName, String lastName, String email, String phone, List<Loan> loans, List<Fine> fines) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.loans = loans;
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

    public List<Loan> getBorrows() {
        return loans;
    }

    public void setBorrows(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }
}
