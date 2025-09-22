package com.example.library.core.exception.detail;

import org.springframework.validation.ObjectError;

import java.util.List;

//Hata aldıgımızda geriye donecek modeli de modellemiş oluyoruz boylelikle
//ExceptionDetailsde message alanı var hem o mesajı gosterecek hem de validationErrors sayesinde hangi fieldda
//ne hata var onu gosteririm
public class ValidationExceptionDetails extends ExceptionDetails{
    //Hem bi mesaj versin - Hem de hangi alan hangi hataya sahip onu gostersin
    private List<ObjectError> validationErrors;

    public ValidationExceptionDetails(String message, List<ObjectError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

    public List<ObjectError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ObjectError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
