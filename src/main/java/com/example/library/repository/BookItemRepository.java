package com.example.library.repository;

import com.example.library.entity.BookItem;
import com.example.library.entity.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookItemRepository extends JpaRepository<BookItem, Integer> {

    //Bir kitaba ait tüm kopyaların sayısını hesaplar
    long countByBookId(int bookId);

    long countByBookIdAndBookStatus(int bookId, BookStatus bookStatus);
}
