package com.loopers.event.domain.dataplatform;

import com.loopers.event.domain.order.OrderPaidEvent;

public interface DataPlatformClient {
    DataPlatformResult sendOrderPaid(OrderPaidEvent event);
}
