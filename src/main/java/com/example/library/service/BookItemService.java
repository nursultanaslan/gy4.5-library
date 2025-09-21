package com.example.library.service;

import com.example.library.entity.BookItem;
import com.example.library.entity.enums.BookStatus;
import com.example.library.repository.BookItemRepository;
import org.springframework.stereotype.Service;

@Service
public class BookItemService {

    private final BookItemRepository bookItemRepository;

    public BookItemService(BookItemRepository bookItemRepository) {
        this.bookItemRepository = bookItemRepository;
    }

    public long getTotalCopies(BookItem bookItem){
        return bookItemRepository.countByBookId(bookItem.getId());
    }

    public long getAvailableCopies(BookItem bookItem){
        return bookItemRepository.countByBookIdAndBookStatus(bookItem.getId(), BookStatus.ACTIVE);
    }
}
