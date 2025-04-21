package com.microservices;

import java.util.List;

public record OrderRequest(
    Integer customerId,
    List<OrderItemRequest> orderItems
) {}
