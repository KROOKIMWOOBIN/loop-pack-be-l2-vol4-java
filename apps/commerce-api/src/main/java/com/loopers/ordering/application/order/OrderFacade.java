package com.loopers.ordering.application.order;

import com.loopers.ordering.domain.order.Order;
import com.loopers.payment.application.payment.PaymentCommandService;
import com.loopers.payment.domain.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderFacade {

    private final OrderCommandService orderCommandService;
    private final PaymentCommandService paymentCommandService;

    @Transactional
    public OrderResult.Detail placeOrder(OrderCommand.Create command) {
        Order order = orderCommandService.createPendingOrder(command);
        Payment payment = paymentCommandService.createRequestedPayment(order.getId(), order.getTotalAmount());
        return OrderResult.Detail.from(order, payment);
    }
}
