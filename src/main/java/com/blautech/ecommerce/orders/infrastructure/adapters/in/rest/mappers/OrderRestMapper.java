package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.mappers;

import com.blautech.ecommerce.orders.domain.models.Detail;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos.CreateOneOrderRequest;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos.DetailRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class OrderRestMapper {
    private OrderRestMapper() {}
    public static Order createOneRequestToDomain(CreateOneOrderRequest createOneOrderRequest) {
        return Order.builder()
            .userId(createOneOrderRequest.getUserId())
            .details(createOneOrderRequest.getDetails().stream().map(OrderRestMapper::detailRequestToDomain).collect(Collectors.toSet()))
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }
    protected static Detail detailRequestToDomain(DetailRequest detailRequest) {
        return Detail.builder()
            .productId(detailRequest.getProductId())
            .quantity(detailRequest.getQuantity())
            .build();
    }
}
