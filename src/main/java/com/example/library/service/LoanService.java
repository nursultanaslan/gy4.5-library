package com.example.library.service;

import com.example.library.dto.loan.request.LoanCreateRequest;
import com.example.library.dto.loan.response.LoanResponse;
import com.example.library.entity.BookItem;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.mapper.LoanMapper;
import com.example.library.repository.LoanRepository;
import com.example.library.rules.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookItemService bookItemService;
    private final BookItemBusinessRules bookItemBusinessRules;
    private final MemberBusinessRules memberBusinessRules;
    private final BookBusinessRules bookBusinessRules;
    private final FineBusinessRules fineBusinessRules;
    private final LoanBusinessRules loanBusinessRules;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository,
                       BookItemService bookItemService,
                       BookItemBusinessRules bookItemBusinessRules,
                       MemberBusinessRules memberBusinessRules,
                       BookBusinessRules bookBusinessRules,
                       FineBusinessRules fineBusinessRules,
                       LoanBusinessRules loanBusinessRules) {
        this.loanRepository = loanRepository;
        this.bookItemService = bookItemService;
        this.bookItemBusinessRules = bookItemBusinessRules;
        this.memberBusinessRules = memberBusinessRules;
        this.bookBusinessRules = bookBusinessRules;
        this.fineBusinessRules = fineBusinessRules;
        this.loanBusinessRules = loanBusinessRules;
        this.loanMapper = LoanMapper.INSTANCE;
    }

    public LoanResponse create(LoanCreateRequest loanRequest){

        BookItem bookItem = bookItemBusinessRules.bookItemShouldExistWithGivenId(loanRequest.getBookItems().getId());
        Member member = memberBusinessRules.memberShouldExistWithGivenId(loanRequest.getMember().getId());

        //Kitabın durumunu kontrol et. INACTIVE se ödünc verme
        bookBusinessRules.checkBookStatus(bookItem.getBookStatus());

        //Kopyasını kontrol et. mevcut kopya sayısı > 0 olmalı
        long totalCopies = bookItemService.getTotalCopies(bookItem);
        long availableCopies = bookItemService.getAvailableCopies(bookItem);
        bookBusinessRules.checkCopies(totalCopies, availableCopies);

        //Üyenin durumunu kontrol et. eğer açık cezası varsa ödünç verme
        fineBusinessRules.checkFineIsPaid(member.getId());

        //halihazırda ödünç almışken return etmeden tekrar ödünç almaya calısıyor mu kontrol et
        loanBusinessRules.checkBookIsReturned(member.getId(), bookItem.getId());

        //bu kontrollerden geçtikten sonra loan kaydı oluşturulur.
        Loan loan = new Loan();
        loan.setLoanDate(LocalDate.now());
        loanRepository.save(loan);


        return loanMapper.createLoanRequestToLoanResponse(loan);

    }

}
