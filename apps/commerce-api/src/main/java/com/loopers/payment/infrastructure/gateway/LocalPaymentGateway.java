package com.loopers.payment.infrastructure.gateway;

import com.loopers.payment.domain.gateway.PaymentGateway;
import com.loopers.payment.domain.gateway.PaymentGatewayResult;
import org.springframework.stereotype.Component;

@Component
public class LocalPaymentGateway implements PaymentGateway {

    @Override
    public PaymentGatewayResult authorize(Long orderId, Long amount, String idempotencyKey) {
        return PaymentGatewayResult.success("tx-" + orderId);
    }

    @Override
    public PaymentGatewayResult capture(String transactionKey) {
        return PaymentGatewayResult.success(transactionKey);
    }

    @Override
    public PaymentGatewayResult voidAuthorization(String transactionKey) {
        return PaymentGatewayResult.success(transactionKey);
    }
}
