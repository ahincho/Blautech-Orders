package com.blautech.ecommerce.orders.application.ports.out;

import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;

import java.util.Optional;

public interface OrderPersistencePort {
    Order createOneOrder(Order order);
    PaginationResult<Order> findOrders(OrderFilters orderFilters);
    Optional<Order> findOneOrderById(String id);
}
