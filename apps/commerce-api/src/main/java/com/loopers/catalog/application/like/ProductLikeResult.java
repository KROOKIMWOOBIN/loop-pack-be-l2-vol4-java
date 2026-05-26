package com.loopers.catalog.application.like;

import com.loopers.catalog.domain.brand.Brand;
import com.loopers.catalog.domain.product.Product;
import com.loopers.catalog.domain.product.ProductStatus;

public record ProductLikeResult(
    Long productId,
    String name,
    Long price,
    ProductStatus status,
    String brandName,
    Long likeCount,
    boolean liked
) {
    public static ProductLikeResult from(Product product, Brand brand, boolean liked) {
        return new ProductLikeResult(
            product.getId(),
            product.getName(),
            product.getPriceAmount(),
            product.getStatus(),
            brand.getName(),
            product.getLikeCount(),
            liked
        );
    }
}
