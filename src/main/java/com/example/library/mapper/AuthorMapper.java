package com.example.library.mapper;

import com.example.library.dto.author.request.CreateAuthorRequest;
import com.example.library.dto.author.request.UpdateAuthorRequest;
import com.example.library.dto.author.response.AuthorListResponse;
import com.example.library.dto.author.response.CreatedAuthorResponse;
import com.example.library.dto.author.response.GetByIdAuthorResponse;
import com.example.library.dto.author.response.UpdatedAuthorResponse;
import com.example.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author createAuthorRequestToAuthor(CreateAuthorRequest authorRequest);

    CreatedAuthorResponse toCreatedAuthorResponse(Author author);

    List<AuthorListResponse> toAuthorListResponse(List<Author> authors);

    GetByIdAuthorResponse toGetByIdAuthorResponse(Author author);

    Author updateAuthorRequestToAuthor(UpdateAuthorRequest updateRequest);

    UpdatedAuthorResponse toUpdatedAuthorResponse(Author author);
}
