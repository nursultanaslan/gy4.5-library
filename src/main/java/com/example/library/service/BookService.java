package com.example.library.service;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.request.UpdateBookRequest;
import com.example.library.dto.book.response.BookResponse;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.dto.book.response.UpdatedBookResponse;
import com.example.library.entity.*;
import com.example.library.entity.enums.BookStatus;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookItemRepository;
import com.example.library.repository.BookRepository;
import com.example.library.rules.BookBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Service
@Validated
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookBusinessRules bookBusinessRules;
    private final BookMapper bookMapper;
    private final BookItemRepository bookItemRepository;

    public BookService(BookRepository bookRepository,
                       AuthorService authorService,
                       BookBusinessRules bookBusinessRules,
                       BookMapper bookMapper,
                       BookItemRepository bookItemRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookBusinessRules = bookBusinessRules;
        this.bookMapper = BookMapper.INSTANCE;
        this.bookItemRepository = bookItemRepository;
    }

    public CreatedBookResponse add(@Valid CreateBookRequest request){
        bookBusinessRules.isbnMustBeUnique(request.getIsbn());
        Book book = bookMapper.createBookRequestToBook(request);

        List<Author> authors = authorService.getAuthorsByIds(request.getAuthorId());
        book.setAuthors(authors);

        bookRepository.save(book);

        return bookMapper.toCreatedBookResponse(book);
    }

    public UpdatedBookResponse update(@Valid UpdateBookRequest request){

        Book book = bookBusinessRules.bookShouldExistWithGivenId(request.getId());
        book = bookMapper.updateBookRequesToBook(request);
        bookRepository.save(book);

        return bookMapper.toUpdatedBookResponse(book);
    }

    public BookResponse getByIdCopyCounts(int bookId){
        Book book = bookBusinessRules.bookShouldExistWithGivenId(bookId);

        long totalCopies = bookItemRepository.countByBookId(bookId);
        long availableCopies = bookItemRepository.countByBookIdAndBookStatus(bookId, BookStatus.ACTIVE);

        BookResponse bookResponse = bookMapper.bookToBookResponse(book);

        bookResponse.setTotalCopies(totalCopies);
        bookResponse.setAvailableCopies(availableCopies);

        return bookResponse;

    }

}
