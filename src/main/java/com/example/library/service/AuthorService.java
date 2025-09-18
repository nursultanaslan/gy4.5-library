package com.example.library.service;

import com.example.library.dto.author.request.CreateAuthorRequest;
import com.example.library.dto.author.request.UpdateAuthorRequest;
import com.example.library.dto.author.response.AuthorListResponse;
import com.example.library.dto.author.response.CreatedAuthorResponse;
import com.example.library.dto.author.response.GetByIdAuthorResponse;
import com.example.library.dto.author.response.UpdatedAuthorResponse;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/*
 * yazar ekle -> add
 * tüm yazarları listele -> getAll
 * yazar sil -> delete
 * idye göre yazar getir -> getCategoryById
 * yazarı güncelle -> update */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public CreatedAuthorResponse add(CreateAuthorRequest authorRequest){
        //Manual Mapping - Dto->Entity
        Author author = new Author();
        author.setFullName(authorRequest.getFullName());
        author.setBio(authorRequest.getBio());
        authorRepository.save(author);

        //Manual Mapping - Entity->Dto
        return new CreatedAuthorResponse(
                author.getFullName(),
                author.getBio()
        );
    }

    public List<AuthorListResponse> getAllAuthors(){

        List<Author> authorList = authorRepository.findAll();
        List<AuthorListResponse> authorListResponses = new ArrayList<>();
        for (Author author : authorList) {
            AuthorListResponse authorResponse = new AuthorListResponse();
            authorResponse.setFullName(author.getFullName());
            authorListResponses.add(authorResponse);
        }
        return authorListResponses;
    }

    public GetByIdAuthorResponse getByIdAuthor(int id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili yazar bulunamadı."));

        return new GetByIdAuthorResponse(
                author.getFullName(),
                author.getBio()
        );
    }

    public List<Author> getAuthorsByIds(List<Integer> ids){
        List<Author> authors = authorRepository.findAllById(ids);
        if (authors.size() != ids.size()){
            throw new NotFoundException("Bir veya daha fazla yazar bulunamadı!");
        }
        return authors;
    }

    public UpdatedAuthorResponse updateAuthor(UpdateAuthorRequest updateRequest){
        final Integer id = updateRequest.getId();
        final Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili yazar bulunamadı."));

//        author.setId(updateRequest.getId());
        author.setFullName(updateRequest.getFullName());
        author.setBio(updateRequest.getBio());
        authorRepository.save(author);

        return new UpdatedAuthorResponse(
                author.getFullName(),
                author.getBio()
        );
    }

    public void deleteAuthorById(Integer id){
        authorRepository.deleteById(id);
    }

}
