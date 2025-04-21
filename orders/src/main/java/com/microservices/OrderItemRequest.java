package com.microservices;

public record OrderItemRequest(
    Integer productId,
    Double quantity
) {}
