package com.example.library.core.exception.detail;

//Hatanın geriye donecegi detay class
//Hata aldıgımız zaman basit string olarak kalmasın diye
public class ExceptionDetails {

    private String message;

    public ExceptionDetails() {
    }

    public ExceptionDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
