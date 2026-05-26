package com.loopers.event.infrastructure.dataplatform;

import com.loopers.event.domain.dataplatform.DataPlatformClient;
import com.loopers.event.domain.dataplatform.DataPlatformResult;
import com.loopers.event.domain.order.OrderPaidEvent;
import org.springframework.stereotype.Component;

@Component
public class NoOpDataPlatformClient implements DataPlatformClient {

    @Override
    public DataPlatformResult sendOrderPaid(OrderPaidEvent event) {
        return DataPlatformResult.success();
    }
}
