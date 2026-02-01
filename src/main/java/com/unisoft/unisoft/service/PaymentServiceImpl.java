package com.unisoft.unisoft.service;

import com.unisoft.unisoft.LoanStatus;
import com.unisoft.unisoft.entity.Loan;
import com.unisoft.unisoft.entity.Payment;
import com.unisoft.unisoft.repository.LoanRepository;
import com.unisoft.unisoft.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final LoanRepository loanRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              LoanRepository loanRepository) {
        this.paymentRepository = paymentRepository;
        this.loanRepository = loanRepository;
    }

    @Override
    public void addPayment(Payment payment) {

        payment.setPaymentDate(LocalDate.now());
        paymentRepository.save(payment);

        Loan loan = loanRepository.findById(payment.getLoanId())
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        BigDecimal totalPaid =
                paymentRepository.getTotalPaidByLoanId(payment.getLoanId());

        if (totalPaid.compareTo(loan.getTotalExpectedAmount()) >= 0) {
            loan.setStatus(LoanStatus.CLOSED);
        }

        loanRepository.save(loan);
    }



    @Override
public List<Payment> getPaymentsByLoanId(Long loanId) {
    return paymentRepository.findByLoanId(loanId);
}

}
