package com.blautech.ecommerce.orders.application.ports.in;

import com.blautech.ecommerce.orders.domain.exceptions.OrderNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;

public interface FindOneOrderUseCase {
    Order execute(String orderId) throws OrderNotFoundException;
}
