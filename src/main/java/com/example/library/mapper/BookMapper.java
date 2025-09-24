package com.example.library.mapper;

import com.example.library.dto.book.request.CreateBookRequest;
import com.example.library.dto.book.request.UpdateBookRequest;
import com.example.library.dto.book.response.BookResponse;
import com.example.library.dto.book.response.CreatedBookResponse;
import com.example.library.dto.book.response.UpdatedBookResponse;
import com.example.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    //Bu mapperın instance'ını oluşturup dısarıdan erişebilmeek icin.
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    //Target : Book (dönüştürecegimiz hedef) //CreateBookRequest'te dönüşümü yapacak source
    @Mapping(target = "publisher.id", source = "publisherId")
    @Mapping(target = "category.id", source = "categoryId")
    Book createBookRequestToBook(CreateBookRequest bookRequest);

    CreatedBookResponse toCreatedBookResponse(Book book);

    @Mapping(target = "publisher.id", source = "publisherId")
    @Mapping(target = "category.id", source = "categoryId")
    Book updateBookRequesToBook(UpdateBookRequest updateRequest);

    UpdatedBookResponse toUpdatedBookResponse(Book book);

    BookResponse bookToBookResponse(Book book);

    Book createBookRequesttoBook(CreateBookRequest request);
}
