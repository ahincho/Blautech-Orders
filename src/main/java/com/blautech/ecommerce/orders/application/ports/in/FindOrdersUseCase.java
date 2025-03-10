package com.blautech.ecommerce.orders.application.ports.in;

import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;

public interface FindOrdersUseCase {
    PaginationResult<Order> execute(OrderFilters orderFilters);
}
