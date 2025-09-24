package com.example.library.rules;

import com.example.library.core.exception.type.BusinessException;
import com.example.library.entity.Book;
import com.example.library.entity.enums.BookStatus;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;



@Component
public class BookBusinessRules {

    private final BookRepository bookRepository;

    public BookBusinessRules(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book bookShouldExistWithGivenId(int id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili kitap bulunamadı"));

    }

    public void isbnMustBeUnique(String isbn){
        Book bookIsbn = bookRepository.findByIsbn(isbn)
                .orElse(null);
        if(bookIsbn != null){
            throw new BusinessException("ISBN numarası eşsiz olmalıdır. Bu ISBN numarası zaten bulunmaktadır.");
        }
    }

    public void checkCopies(long totalCopies, long availableCopies){
        if(availableCopies > totalCopies){
            throw new RuntimeException("Mevcut kopya sayısı, toplam kopya sayısından büyük olamaz");
        }

        if(availableCopies<0){
            throw new RuntimeException("Mevcut kopya sayısı negatif olamaz");
        }
    }


    public void checkBookStatus(BookStatus bookStatus){
        if (bookStatus.equals(BookStatus.INACTIVE))
            throw new RuntimeException("Bu kitap aktif durumda olmadığından ödünç verilemez ve rezervasyon alınamaz");
    }
}
