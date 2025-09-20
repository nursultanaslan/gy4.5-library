package com.example.library.dto.book.response;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import com.example.library.entity.enums.BookStatus;

import java.util.List;

public class GetListBookResponse {
    private Integer id;
    private String title;
    private Integer totalPage;
    private String isbn;
    private String imageUrl;
    private BookStatus bookStatus;
    private Publisher publisher;
    private Category category;
    private List<Author> authors;

}
