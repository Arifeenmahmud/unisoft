package com.unisoft.unisoft.service;

import com.unisoft.unisoft.entity.Payment;

import java.util.List;

public interface PaymentService {
    void addPayment(Payment payment);


      List<Payment> getPaymentsByLoanId(Long loanId);
}
