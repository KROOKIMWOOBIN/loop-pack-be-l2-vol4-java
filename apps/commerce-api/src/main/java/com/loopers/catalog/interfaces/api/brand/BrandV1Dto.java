package com.loopers.catalog.interfaces.api.brand;

import com.loopers.catalog.application.brand.BrandResult;

public class BrandV1Dto {
    public record BrandResponse(
        Long id,
        String name,
        String description
    ) {
        public static BrandResponse from(BrandResult result) {
            return new BrandResponse(
                result.id(),
                result.name(),
                result.description()
            );
        }
    }
}
