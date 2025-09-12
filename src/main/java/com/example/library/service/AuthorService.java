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
 * kategori ekle -> add
 * tüm kategorileri listele -> getAll
 * kategori sil -> delete
 *
 *
 * idye göre kategori getir -> getCategoryById
 * kategori güncelle -> update */
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public CreatedAuthorResponse add(CreateAuthorRequest authorRequest){
        Author author = new Author();
        author.setFullName(authorRequest.getFullName());
        author.setBio(authorRequest.getBio());
        authorRepository.save(author);

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

    public UpdatedAuthorResponse updateAuthor(UpdateAuthorRequest updateRequest){
        final Integer id = updateRequest.getId();
        final Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bu id ile ilgili yazar bulunamadı."));

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
