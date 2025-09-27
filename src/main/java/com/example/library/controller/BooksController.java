package com.example.library.controller;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.dto.book.response.GetListBookResponse;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<GetListBookResponse> getList(){
        return bookService.getList();
    }

    @PostMapping()
    public CreatedBookResponse add(@RequestBody CreateBookRequest request){
        return bookService.add(request);
    }

}
