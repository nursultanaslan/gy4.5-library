package com.example.library.service;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.request.UpdateBookRequest;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.dto.book.response.UpdatedBookResponse;
import com.example.library.entity.*;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository,
                       AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public CreatedBookResponse add(CreateBookRequest request){

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setTotalPage(request.getTotalPage());
        book.setIsbn(request.getIsbn());
        book.setImageUrl(request.getImageUrl());
        book.setBookStatus(request.getBookStatus());

        Publisher publisher = new Publisher();
        publisher.setId(request.getPublisherId());
        book.setPublisher(publisher);

        Category category = new Category();
        category.setId(request.getCategoryId());
        book.setCategory(category);


        List<Author> authors = authorService.getAuthorsByIds(request.getAuthorId());
        book.setAuthors(authors);

        bookRepository.save(book);

        return new CreatedBookResponse(
                book.getTitle(),
                book.getTotalPage(),
                book.getBookStatus(),
                book.getPublisher(),
                book.getCategory(),
                book.getAuthors()
        );
    }

    public UpdatedBookResponse update(UpdateBookRequest request){
        final Integer id = request.getId();
        final Book book = bookRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili bir kitap bulunamadı!"));

        book.setId(request.getId());
        book.setTitle(request.getTitle());
        book.setTotalPage(request.getTotalPage());
        book.setIsbn(request.getIsbn());
        book.setImageUrl(request.getImageUrl());
        book.setBookStatus(request.getBookStatus());
        book.setPublisher(request.getPublisher());
        book.setCategory(request.getCategory());
        book.setAuthors(request.getAuthors());

        bookRepository.save(book);

        return new UpdatedBookResponse(
                book.getId(),
                book.getTitle(),
                book.getTotalPage(),
                book.getIsbn(),
                book.getImageUrl(),
                book.getPublisher(),
                book.getCategory(),
                book.getAuthors()
        );

    }


}
