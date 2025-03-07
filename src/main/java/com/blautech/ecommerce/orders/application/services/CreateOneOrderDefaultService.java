package com.blautech.ecommerce.orders.application.services;

import com.blautech.ecommerce.orders.application.ports.in.CreateOneOrderUseCase;
import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.orders.application.ports.out.UserPersistencePort;
import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.domain.exceptions.UserNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Detail;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateOneOrderDefaultService implements CreateOneOrderUseCase {
    private final UserPersistencePort userPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final OrderPersistencePort orderPersistencePort;
    public CreateOneOrderDefaultService(
        UserPersistencePort userPersistencePort,
        ProductPersistencePort productPersistencePort,
        OrderPersistencePort orderPersistencePort
    ) {
        this.userPersistencePort = userPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Order execute(Order order) throws UserNotFoundException, ProductNotFoundException {
        Optional<User> optionalUser = this.userPersistencePort.findOneUserById(order.getUserId());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(String.format("User with id '%s' not found", order.getUserId()));
        }
        List<Long> productIds = order.getDetails().stream().map(Detail::getProductId).toList();
        if (!this.productPersistencePort.existsProductsByIds(productIds)) {
            throw new ProductNotFoundException(String.format("One or more products with ids '%s' not found", productIds));
        }
        return this.orderPersistencePort.createOneOrder(order);
    }
}
