package com.loopers.catalog.infrastructure.product;

import com.loopers.catalog.domain.product.ProductRepository;
import com.loopers.catalog.domain.product.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockServiceConfig {

    @Bean
    public StockService stockService(ProductRepository productRepository) {
        return new StockService(productRepository);
    }
}
