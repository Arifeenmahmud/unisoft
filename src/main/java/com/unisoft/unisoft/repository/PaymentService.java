package com.unisoft.unisoft.repository;

import com.unisoft.unisoft.entity.Payment;

import java.util.List;

public interface PaymentService {

    void addPayment(Payment payment);

    List<Payment> getPaymentsByLoanId(Long loanId);
}

