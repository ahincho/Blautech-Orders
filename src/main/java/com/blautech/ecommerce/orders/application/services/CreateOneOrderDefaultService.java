package com.blautech.ecommerce.orders.application.services;

import com.blautech.ecommerce.orders.application.ports.in.CreateOneOrderUseCase;
import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.application.ports.out.UserPersistencePort;
import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.domain.exceptions.UserNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateOneOrderDefaultService implements CreateOneOrderUseCase {
    private final UserPersistencePort userPersistencePort;
    private final OrderPersistencePort orderPersistencePort;
    public CreateOneOrderDefaultService(
        UserPersistencePort userPersistencePort,
        OrderPersistencePort orderPersistencePort
    ) {
        this.userPersistencePort = userPersistencePort;
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Order execute(Order order) throws UserNotFoundException, ProductNotFoundException {
        Optional<User> optionalUser = this.userPersistencePort.findOneUserById(order.getUserId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(String.format("User with id '%s' not found", order.getUserId()));
        }
        return this.orderPersistencePort.createOneOrder(order);
    }
}
