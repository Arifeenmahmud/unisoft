package com.unisoft.unisoft.controller;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.dto.LoanSummaryDto;
import com.unisoft.unisoft.entity.Loan;
import com.unisoft.unisoft.repository.PaymentRepository;
import com.unisoft.unisoft.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final PaymentRepository paymentRepository;

    public LoanController(LoanService loanService,
                          PaymentRepository paymentRepository) {
        this.loanService = loanService;
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping
    public Page<Loan> getLoans(
            @RequestParam(required = false) LoanStatus status,
            Pageable pageable
    ) {
        return loanService.getLoans(status, pageable);
    }

    @GetMapping("/{id}/summary")
    public LoanSummaryDto getLoanSummary(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        BigDecimal totalPaid =
                paymentRepository.getTotalPaidByLoanId(id);

        return new LoanSummaryDto(loan, totalPaid);
    }
}
