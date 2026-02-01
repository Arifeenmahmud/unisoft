package com.unisoft.unisoft.repository;

import com.unisoft.unisoft.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//
//    @Query("SELECT COALESCE(SUM(p.amountPaid), 0) FROM Payment p WHERE p.loanId = :loanId")
//    BigDecimal getTotalPaidByLoanId(Long loanId);
//
//
//    @Query("SELECT COALESCE(SUM(p.amountPaid), 0) FROM Payment p WHERE p.loanId = :loanId")
//    BigDecimal getTotalPaidByLoanId(Long loanId);
//
//}


import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByLoanId(Long loanId);

    @Query("SELECT COALESCE(SUM(p.amountPaid), 0) FROM Payment p WHERE p.loanId = :loanId")
    BigDecimal getTotalPaidByLoanId(Long loanId);
}

