package com.example.library.core.exception;

import com.example.library.core.exception.detail.ExceptionDetails;
import com.example.library.core.exception.detail.ValidationExceptionDetails;
import com.example.library.core.exception.type.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Bütün hataların fırladıgı anda gelecegi class
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionDetails handleValidationException(MethodArgumentNotValidException ex){
        return new ValidationExceptionDetails(
                "Validation Erron"
        , ex.getBindingResult().getAllErrors());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(){
        return "Runtime Error";
    }

    //BusinessExceptiona özel bir hata yakalama fonk. yazıcaz
    //Her exception handler fırlayan exceptionı parametre olarak alır
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDetails handleBusinessException(BusinessException e){
        return new ExceptionDetails(  //Hata mesajı json olarak gelecek böylelikle
                e.getMessage()
        );
    }
}
