package com.loopers.catalog.application.product;

import com.loopers.catalog.domain.brand.Brand;
import com.loopers.catalog.domain.product.Product;
import com.loopers.catalog.domain.product.ProductStatus;

public record ProductResult(
    Long id,
    Long brandId,
    String brandName,
    String name,
    String description,
    Long price,
    Integer stockQuantity,
    Long likeCount,
    ProductStatus status,
    boolean liked
) {
    public static ProductResult from(Product product, Brand brand) {
        return from(product, brand, false);
    }

    public static ProductResult from(Product product, Brand brand, boolean liked) {
        return new ProductResult(
            product.getId(),
            product.getBrandId(),
            brand.getName(),
            product.getName(),
            product.getDescription(),
            product.getPriceAmount(),
            product.getStockQuantity(),
            product.getLikeCount(),
            product.getStatus(),
            liked
        );
    }
}
