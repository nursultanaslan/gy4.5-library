package com.example.library.controller;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public CreatedBookResponse add(@RequestBody CreateBookRequest request){
        return bookService.add(request);
    }

}
