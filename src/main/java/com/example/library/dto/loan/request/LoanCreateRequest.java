package com.example.library.dto.loan.request;

import com.example.library.entity.BookItem;
import com.example.library.entity.Member;

public class LoanCreateRequest {

    private BookItem bookItems;
    private Member member;

    public BookItem getBookItems() {
        return bookItems;
    }

    public void setBookItems(BookItem bookItems) {
        this.bookItems = bookItems;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
