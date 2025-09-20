package com.example.library.rules;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;

@Component
public class AuthorBusinessRules {

    private final AuthorRepository authorRepository;

    public AuthorBusinessRules(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author authorShouldExistWithGivenId(int id){
        return authorRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Bu id ile ilgili yazar bulunamadı."));

    }

    public List<Author> authorsShouldExistWithGiveIds(List<Integer> ids){
        List<Author> authors = authorRepository.findAllById(ids);
        if (authors.size() != ids.size()){
            throw new NotFoundException("Bir veya daha fazla yazar bulunamadı!");
        }
        return authors;
    }
}
