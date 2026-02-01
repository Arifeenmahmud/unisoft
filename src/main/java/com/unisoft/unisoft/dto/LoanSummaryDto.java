package com.unisoft.unisoft.dto;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.entity.Loan;

import java.math.BigDecimal;

public class LoanSummaryDto {

    private Loan loan;
    private BigDecimal totalPaid;
    private BigDecimal remainingBalance;
    private LoanStatus status;

    public LoanSummaryDto(Loan loan, BigDecimal totalPaid) {
        this.loan = loan;
        this.totalPaid = totalPaid;
        this.remainingBalance =
                loan.getTotalExpectedAmount().subtract(totalPaid);
        this.status = loan.getStatus();
    }

    // getters
}

