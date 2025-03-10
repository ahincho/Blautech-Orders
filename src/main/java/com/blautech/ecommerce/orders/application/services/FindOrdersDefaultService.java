package com.blautech.ecommerce.orders.application.services;

import com.blautech.ecommerce.orders.application.ports.in.FindOrdersUseCase;
import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;

import org.springframework.stereotype.Service;

@Service
public class FindOrdersDefaultService implements FindOrdersUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public FindOrdersDefaultService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public PaginationResult<Order> execute(OrderFilters orderFilters) {
        return this.orderPersistencePort.findOrders(orderFilters);
    }
}
