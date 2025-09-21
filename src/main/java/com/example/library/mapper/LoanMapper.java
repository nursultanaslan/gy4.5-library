package com.example.library.mapper;

import com.example.library.dto.loan.request.LoanCreateRequest;
import com.example.library.dto.loan.response.LoanResponse;
import com.example.library.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan loanCreateRequestToLoan(LoanCreateRequest loanRequest);

    LoanResponse createLoanRequestToLoanResponse(Loan loan);


}
