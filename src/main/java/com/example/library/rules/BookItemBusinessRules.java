package com.example.library.rules;

import com.example.library.entity.BookItem;
import com.example.library.repository.BookItemRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class BookItemBusinessRules {
    private final BookItemRepository bookItemRepository;

    public BookItemBusinessRules(BookItemRepository bookItemRepository) {
        this.bookItemRepository = bookItemRepository;
    }


    public BookItem bookItemShouldExistWithGivenId(int id){
        return bookItemRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili bir kitap bulunamadı"));
    }
}
