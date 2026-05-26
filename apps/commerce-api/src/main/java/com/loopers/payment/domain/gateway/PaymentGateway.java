package com.loopers.payment.domain.gateway;

public interface PaymentGateway {
    PaymentGatewayResult authorize(Long orderId, Long amount, String idempotencyKey);

    PaymentGatewayResult capture(String transactionKey);

    PaymentGatewayResult voidAuthorization(String transactionKey);
}
