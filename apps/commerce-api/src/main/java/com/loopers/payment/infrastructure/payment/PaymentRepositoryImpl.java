package com.loopers.payment.infrastructure.payment;

import com.loopers.payment.domain.payment.Payment;
import com.loopers.payment.domain.payment.PaymentRepository;
import com.loopers.payment.domain.payment.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment save(Payment payment) {
        PaymentJpaEntity entity = paymentJpaRepository.findByOrderId(payment.getOrderId())
            .orElseGet(() -> PaymentJpaEntity.from(payment));
        entity.apply(payment);
        return paymentJpaRepository.save(entity).toDomain();
    }

    @Override
    public Optional<Payment> findByOrderId(Long orderId) {
        return paymentJpaRepository.findByOrderId(orderId).map(PaymentJpaEntity::toDomain);
    }

    @Override
    public List<Payment> findAllByOrderIds(Collection<Long> orderIds) {
        return paymentJpaRepository.findByOrderIdIn(orderIds)
            .stream()
            .map(PaymentJpaEntity::toDomain)
            .toList();
    }

    @Override
    public List<Payment> findRequestedPayments() {
        return paymentJpaRepository.findByStatus(PaymentStatus.REQUESTED)
            .stream()
            .map(PaymentJpaEntity::toDomain)
            .toList();
    }

    @Override
    public List<Payment> findRequestedPaymentsForUpdate(int limit) {
        int size = limit <= 0 ? 100 : limit;
        return paymentJpaRepository.findByStatusForUpdate(PaymentStatus.REQUESTED, PageRequest.of(0, size))
            .stream()
            .map(PaymentJpaEntity::toDomain)
            .toList();
    }
}
