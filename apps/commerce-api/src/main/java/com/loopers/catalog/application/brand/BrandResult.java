package com.loopers.catalog.application.brand;

import com.loopers.catalog.domain.brand.Brand;

public record BrandResult(
    Long id,
    String name,
    String description,
    boolean active
) {
    public static BrandResult from(Brand brand) {
        return new BrandResult(
            brand.getId(),
            brand.getName(),
            brand.getDescription(),
            brand.isActive()
        );
    }
}
