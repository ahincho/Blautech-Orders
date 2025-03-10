package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.orders.application.ports.in.FindOneOrderUseCase;
import com.blautech.ecommerce.orders.domain.exceptions.OrderNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class FindOneOrderRestController {
    private final FindOneOrderUseCase findOneOrderUseCase;
    public FindOneOrderRestController(FindOneOrderUseCase findOneOrderUseCase) {
        this.findOneOrderUseCase = findOneOrderUseCase;
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOneOrder(
        @PathVariable("orderId") String orderId
    ) throws OrderNotFoundException {
        Order order = this.findOneOrderUseCase.execute(orderId);
        return ResponseEntity.ok(order);
    }
}
