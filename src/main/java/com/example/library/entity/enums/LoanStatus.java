package com.example.library.entity.enums;

public enum LoanStatus {
    OPEN,  //Kitap ödünç alındı, henüz iade edilmedi ve süresi dolmadı
    CLOSED, //kitap iade edildikten sonra loan status kapalı durumuna getirilir
    LATE  //Kitabın iade tarihi doldu ancak henüz iade edilmedi.
}
