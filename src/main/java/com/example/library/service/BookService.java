package com.example.library.service;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.request.UpdateBookRequest;
import com.example.library.dto.book.response.BookResponse;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.dto.book.response.GetListBookResponse;
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

import java.util.ArrayList;
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

    public List<GetListBookResponse> getList(){
        List<Book> books = bookRepository.findAll();
        List<GetListBookResponse> bookResponseList = new ArrayList<>();
        for (Book book: books){
            GetListBookResponse response = new GetListBookResponse();
            response.setId(book.getId());
            response.setTitle(book.getTitle());
            response.setTotalPage(book.getTotalPage());
            response.setIsbn(book.getIsbn());
            response.setImageUrl(book.getImageUrl());
            response.setBookStatus(book.getBookStatus());
            response.setPublisher(book.getPublisher());
            response.setCategory(book.getCategory());
            response.setAuthor(book.getAuthor());
            bookResponseList.add(response);
        }
        return bookResponseList;
    }

    public CreatedBookResponse add(@Valid CreateBookRequest request){

        bookBusinessRules.isbnMustBeUnique(request.getIsbn());

        //Manual Mapping
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setTotalPage(request.getTotalPage());
        book.setIsbn(request.getIsbn());
        book.setImageUrl(request.getImageUrl());
        book.setBookStatus(BookStatus.getDefault());

        Publisher publisher = new Publisher();
        publisher.setId(request.getPublisherId());
        book.setPublisher(publisher);

        Category category = new Category();
        category.setId(request.getCategoryId());
        book.setCategory(category);

        Author author = new Author();
        author.setId(request.getAuthorId());
        book.setAuthor(author);

        return bookMapper.toCreatedBookResponse(bookRepository.save(book));
    }

    public UpdatedBookResponse update(@Valid UpdateBookRequest request){

        Book book = bookBusinessRules.bookShouldExistWithGivenId(request.getId());
        book = bookMapper.updateBookRequesToBook(request);

        return bookMapper.toUpdatedBookResponse(bookRepository.save(book));
    }

    public BookResponse getByIdCopiesCount(int bookId){

        Book book = bookBusinessRules.bookShouldExistWithGivenId(bookId);

        long totalCopies = bookItemRepository.countByBookId(bookId);
        long availableCopies = bookItemRepository.countByBookIdAndBookStatus(bookId, BookStatus.ACTIVE);

        BookResponse bookResponse = bookMapper.bookToBookResponse(book);

        bookResponse.setTotalCopies(totalCopies);
        bookResponse.setAvailableCopies(availableCopies);

        return bookResponse;

    }

}
