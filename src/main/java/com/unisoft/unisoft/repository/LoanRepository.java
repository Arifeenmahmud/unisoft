package com.unisoft.unisoft.repository;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Page<Loan> findByStatus(LoanStatus status, Pageable pageable);
}
