package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.orders.application.ports.in.FindOrdersUseCase;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos.OrderQueryRequest;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class FindOrdersRestController {
    private final FindOrdersUseCase findOrdersUseCase;
    public FindOrdersRestController(FindOrdersUseCase findOrdersUseCase) {
        this.findOrdersUseCase = findOrdersUseCase;
    }
    @GetMapping
    public ResponseEntity<PaginationResult<Order>> findOrders(
        @ModelAttribute @Valid OrderQueryRequest orderQueryRequest
    ) {
        OrderFilters orderFilters = OrderRestMapper.queryRequestToDomain(orderQueryRequest);
        PaginationResult<Order> orderPaginationResult = this.findOrdersUseCase.execute(orderFilters);
        if (orderPaginationResult.getItems().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderPaginationResult);
    }
}
