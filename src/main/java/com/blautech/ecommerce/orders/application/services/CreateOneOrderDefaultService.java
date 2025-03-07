package com.blautech.ecommerce.orders.application.services;

import com.blautech.ecommerce.orders.application.ports.in.CreateOneOrderUseCase;
import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.domain.exceptions.UserNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;

import org.springframework.stereotype.Service;

@Service
public class CreateOneOrderDefaultService implements CreateOneOrderUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public CreateOneOrderDefaultService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Order execute(Order order) throws UserNotFoundException, ProductNotFoundException {
        return this.orderPersistencePort.createOneOrder(order);
    }
}
