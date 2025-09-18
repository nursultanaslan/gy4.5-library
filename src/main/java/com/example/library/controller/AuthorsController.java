package com.example.library.controller;

import com.example.library.dto.author.request.CreateAuthorRequest;
import com.example.library.dto.author.request.UpdateAuthorRequest;
import com.example.library.dto.author.response.AuthorListResponse;
import com.example.library.dto.author.response.CreatedAuthorResponse;
import com.example.library.dto.author.response.GetByIdAuthorResponse;
import com.example.library.dto.author.response.UpdatedAuthorResponse;
import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public CreatedAuthorResponse add(@RequestBody CreateAuthorRequest authorRequest){
        return authorService.add(authorRequest);
    }

    @GetMapping()
    public List<AuthorListResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getByIdAuthor(@PathVariable int id){
        return authorService.getByIdAuthor(id);
    }

    @PatchMapping
    public UpdatedAuthorResponse updateAuthor(@RequestBody UpdateAuthorRequest updateRequest){
        return authorService.updateAuthor(updateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Integer id){
        authorService.deleteAuthorById(id);
    }

    @GetMapping("/by-ids")
    public List<Author> getAuthorsByIds(@RequestParam List<Integer> ids){
        return authorService.getAuthorsByIds(ids);
    }

}
