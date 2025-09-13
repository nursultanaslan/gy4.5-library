package com.example.library.dto.user.response;

import com.example.library.entity.Borrow;
import com.example.library.entity.Fine;

import java.util.List;

public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Borrow> borrows;
    private List<Fine> fines;

    public UserResponse() {
    }

    public UserResponse(Integer id, String firstName, String lastName, String email, List<Borrow> borrows, List<Fine> fines) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrows = borrows;
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

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }
}
