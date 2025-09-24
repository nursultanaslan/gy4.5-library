package com.example.library.service;

import com.example.library.dto.author.request.CreateAuthorRequest;
import com.example.library.dto.author.request.UpdateAuthorRequest;
import com.example.library.dto.author.response.AuthorListResponse;
import com.example.library.dto.author.response.CreatedAuthorResponse;
import com.example.library.dto.author.response.GetByIdAuthorResponse;
import com.example.library.dto.author.response.UpdatedAuthorResponse;
import com.example.library.entity.Author;
import com.example.library.mapper.AuthorMapper;
import com.example.library.repository.AuthorRepository;
import com.example.library.rules.AuthorBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorBusinessRules authorBusinessRules;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository,
                         AuthorBusinessRules authorBusinessRules,
                         AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorBusinessRules = authorBusinessRules;
        this.authorMapper = AuthorMapper.INSTANCE;
    }

    public CreatedAuthorResponse add(@Valid CreateAuthorRequest authorRequest){
        Author author = authorMapper.createAuthorRequestToAuthor(authorRequest);
        authorRepository.save(author);

        return authorMapper.toCreatedAuthorResponse(author);
    }

    public List<AuthorListResponse> getAllAuthors(){

        List<Author> authors = authorRepository.findAll();

        return authorMapper.toAuthorListResponse(authors);
    }

    public GetByIdAuthorResponse getByIdAuthor(int id){
        Author author = authorBusinessRules.authorShouldExistWithGivenId(id);
        return authorMapper.toGetByIdAuthorResponse(author);
    }

    public List<Author> getAuthorsByIds(List<Integer> ids){
        return authorBusinessRules.getAuthorsShouldExistWithGivenIds(ids);
    }

    public UpdatedAuthorResponse updateAuthor(@Valid UpdateAuthorRequest updateRequest){
        Author author = authorBusinessRules.authorShouldExistWithGivenId(updateRequest.getId());
        author = authorMapper.updateAuthorRequestToAuthor(updateRequest);
        author = authorRepository.save(author);

        return authorMapper.toUpdatedAuthorResponse(author);
    }

    public void deleteAuthorById(Integer id){
        authorRepository.deleteById(id);
    }

}
