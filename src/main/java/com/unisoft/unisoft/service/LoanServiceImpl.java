package com.unisoft.unisoft.service;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.entity.Loan;
import com.unisoft.unisoft.repository.LoanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(Loan loan) {

        BigDecimal interest =
                loan.getPrincipalAmount()
                        .multiply(BigDecimal.valueOf(loan.getInterestRate()))
                        .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);

        BigDecimal totalExpected =
                loan.getPrincipalAmount().add(interest);

        loan.setTotalExpectedAmount(totalExpected);
        loan.setEmiAmount(
                totalExpected.divide(
                        BigDecimal.valueOf(loan.getTenureMonths()),
                        RoundingMode.HALF_UP
                )
        );

        loan.setStatus(LoanStatus.ACTIVE);
        loan.setCreatedDate(LocalDate.now());

        return loanRepository.save(loan);
    }

    @Override
    public Page<Loan> getLoans(LoanStatus status, Pageable pageable) {
        return status == null
                ? loanRepository.findAll(pageable)
                : loanRepository.findByStatus(status, pageable);
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }
}
