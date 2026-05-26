package com.loopers.catalog.application.like;

public class ProductLikeQuery {
    public record MyLikes(
        String userId,
        int page,
        int size
    ) {
        public MyLikes {
            if (page < 0) {
                page = 0;
            }
            if (size <= 0) {
                size = 20;
            }
        }
    }
}
