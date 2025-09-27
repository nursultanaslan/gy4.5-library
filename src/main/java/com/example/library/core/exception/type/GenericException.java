package com.example.library.core.exception.type;


import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{

    private HttpStatus httpStatus;
    private String errorMessage;

}
