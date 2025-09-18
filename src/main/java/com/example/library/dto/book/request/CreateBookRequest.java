package com.example.library.dto.book.request;

import com.example.library.entity.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

/*başlık
 * sayfa sayısı
 * isbn numarası
 * yayın evi
 * categorisi
 * kitabın kapak fotografı
 * yazarı
 * kitabın varsa kopyaları
 * */
public class CreateBookRequest {
    //Veritabanına bir book eklerken kullanıcıdan neler talep edeceğim?
    @NotBlank
    private String title;
    @NotNull
    private Integer totalPage;
    @NotBlank
    @Pattern(regexp = "^\\d{13}$")
    private String isbn;

    private String imageUrl;

    private BookStatus bookStatus;

    private Integer publisherId;
    private Integer categoryId;

    private List<Integer> authorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public List<Integer> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Integer> authorId) {
        this.authorId = authorId;
    }
}
