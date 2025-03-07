package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.orders.application.ports.in.CreateOneOrderUseCase;
import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.domain.exceptions.UserNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos.CreateOneOrderRequest;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/orders")
public class CreateOneOrderRestController {
    private final CreateOneOrderUseCase createOneOrderUseCase;
    public CreateOneOrderRestController(CreateOneOrderUseCase createOneOrderUseCase) {
        this.createOneOrderUseCase = createOneOrderUseCase;
    }
    @PostMapping
    public ResponseEntity<Order> createOneOrder(
        @RequestBody @Valid CreateOneOrderRequest createOneOrderRequest
    ) throws UserNotFoundException, ProductNotFoundException {
        Order order = OrderRestMapper.createOneRequestToDomain(createOneOrderRequest);
        Order savedOrder = this.createOneOrderUseCase.execute(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("7{orderId}").buildAndExpand(savedOrder.getId()).toUri();
        return ResponseEntity.created(uri).body(savedOrder);
    }
}
