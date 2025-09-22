package com.example.library.core.exception.type;

//RuntimeException türünde kendi BusinessExceptionımı oluşturdum
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
