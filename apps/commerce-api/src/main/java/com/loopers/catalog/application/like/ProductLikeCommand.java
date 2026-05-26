package com.loopers.catalog.application.like;

public class ProductLikeCommand {
    public record Like(
        String userId,
        Long productId
    ) {}

    public record Unlike(
        String userId,
        Long productId
    ) {}
}
