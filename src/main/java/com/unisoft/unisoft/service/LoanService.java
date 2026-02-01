package com.unisoft.unisoft.service;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanService {

    Loan createLoan(Loan loan);

    Page<Loan> getLoans(LoanStatus status, Pageable pageable);

    Loan getLoanById(Long id);
}
