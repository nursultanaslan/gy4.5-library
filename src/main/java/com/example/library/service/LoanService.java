package com.example.library.service;

import com.example.library.dto.loan.request.LoanCreateRequest;
import com.example.library.dto.loan.request.LoanReturnRequest;
import com.example.library.dto.loan.response.LoanResponse;
import com.example.library.entity.BookItem;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.entity.enums.BookStatus;
import com.example.library.mapper.LoanMapper;
import com.example.library.repository.BookItemRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.rules.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Service
@Validated
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookItemRepository bookItemRepository;
    private final BookItemService bookItemService;
    private final BookItemBusinessRules bookItemBusinessRules;
    private final MemberBusinessRules memberBusinessRules;
    private final BookBusinessRules bookBusinessRules;
    private final FineBusinessRules fineBusinessRules;
    private final LoanBusinessRules loanBusinessRules;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository,
                       BookItemRepository bookItemRepository,
                       BookItemService bookItemService,
                       BookItemBusinessRules bookItemBusinessRules,
                       MemberBusinessRules memberBusinessRules,
                       BookBusinessRules bookBusinessRules,
                       FineBusinessRules fineBusinessRules,
                       LoanBusinessRules loanBusinessRules) {
        this.loanRepository = loanRepository;
        this.bookItemRepository = bookItemRepository;
        this.bookItemService = bookItemService;
        this.bookItemBusinessRules = bookItemBusinessRules;
        this.memberBusinessRules = memberBusinessRules;
        this.bookBusinessRules = bookBusinessRules;
        this.fineBusinessRules = fineBusinessRules;
        this.loanBusinessRules = loanBusinessRules;
        this.loanMapper = LoanMapper.INSTANCE;
    }

    public LoanResponse create(@Valid LoanCreateRequest loanRequest){

        BookItem bookItem = bookItemBusinessRules.bookItemShouldExistWithGivenId(loanRequest.getBookItemId());
        Member member = memberBusinessRules.memberShouldExistWithGivenId(loanRequest.getMemberId());

        //Kitabın durumunu kontrol et. INACTIVE se ödünc verme ?
        bookBusinessRules.checkBookStatus(bookItem.getBookStatus());

        //Kopyasını kontrol et. mevcut kopya sayısı > 0 olmalı
        long totalCopies = bookItemService.getTotalCopies(bookItem);
        long availableCopies = bookItemService.getAvailableCopies(bookItem);
        bookBusinessRules.checkCopies(totalCopies, availableCopies);

        //Üyenin durumunu kontrol et. eğer açık cezası varsa ödünç verme
        fineBusinessRules.checkFineIsPaid(member.getId());

        //halihazırda ödünç almışken return etmeden tekrar ödünç almaya calısıyor mu kontrol et
        loanBusinessRules.checkBookIsReturned(member.getId(), bookItem.getId());

        memberBusinessRules.checkMaxLoanLimit(member);

        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanBusinessRules.calcDueDate(member);

        //bu kontrollerden geçtikten sonra loan kaydı oluşturulur.
        Loan loan = loanMapper.loanCreateRequestToLoan(loanRequest);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loanRepository.save(loan);

        bookItem.setBookStatus(BookStatus.INACTIVE);
        bookItemRepository.save(bookItem);

        return loanMapper.createLoanRequestToLoanResponse(loan);

    }

//    private LoanResponse returnBook(LoanReturnRequest loanRequest){
//        Loan loan = loanBusinessRules.loanShouldExist(loanRequest.getLoanId());
//        LocalDate returnDate = LocalDate.now();
//        loan.setReturnDate(returnDate);
//
//        loanBusinessRules.calcFineAmount(loan.getLoanDate(), )
//        return new LoanResponse();
//    }

}
