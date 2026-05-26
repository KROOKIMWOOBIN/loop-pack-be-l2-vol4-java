package com.loopers.catalog.application.brand;

public class BrandCommand {
    public record Create(
        String name,
        String description
    ) {}

    public record Update(
        String name,
        String description
    ) {}
}
