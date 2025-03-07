package com.blautech.ecommerce.orders.application.services;

import com.blautech.ecommerce.orders.application.ports.in.FindOneOrderUseCase;
import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.domain.exceptions.OrderNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindOneOrderDefaultService implements FindOneOrderUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public FindOneOrderDefaultService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Order execute(String orderId) throws OrderNotFoundException {
        Optional<Order> optionalOrder = this.orderPersistencePort.findOneOrderById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException(String.format("Order with id '%s' not found", orderId));
        }
        return optionalOrder.get();
    }
}
