package com.loopers.catalog.application.product;

import com.loopers.catalog.domain.product.ProductSearchCondition;
import com.loopers.catalog.domain.product.ProductSortType;
import com.loopers.catalog.domain.product.ProductStatus;

public class ProductQuery {
    public record Search(
        Long brandId,
        int page,
        int size,
        String sort,
        String userId
    ) {
        public ProductSearchCondition toCondition() {
            return new ProductSearchCondition(brandId, ProductStatus.ON_SALE, page, size, ProductSortType.from(sort));
        }
    }

    public record AdminSearch(
        Long brandId,
        int page,
        int size,
        String sort
    ) {
        public ProductSearchCondition toCondition() {
            return new ProductSearchCondition(brandId, null, page, size, ProductSortType.from(sort));
        }
    }
}
