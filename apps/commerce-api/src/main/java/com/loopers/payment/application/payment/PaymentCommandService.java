package com.loopers.payment.application.payment;

import com.loopers.payment.domain.payment.Payment;
import com.loopers.payment.domain.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentCommandService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment createRequestedPayment(Long orderId, Long amount) {
        return paymentRepository.save(new Payment(orderId, amount));
    }
}
