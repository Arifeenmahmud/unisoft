package com.unisoft.unisoft.controller;

import com.unisoft.unisoft.entity.Payment;
import com.unisoft.unisoft.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return "Payment added successfully";
    }

    @GetMapping
    public List<Payment> getPayments(
            @RequestParam Long loanId
    ) {
        return paymentService.getPaymentsByLoanId(loanId);
    }
}

