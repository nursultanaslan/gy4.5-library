package com.example.library.repository;

import com.example.library.entity.Loan;
import com.example.library.entity.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

//    //üye ve kitap idsine göre kitabı iade etmedigi durumu sorgula
//    boolean existsByMemberIdAndBookItemIdAndLoanStatus(int memberId, int bookItemId, LoanStatus loanStatus);
//
//    long countByMemberIdAndLoanStatus(int memberId, LoanStatus loanStatus);

}
