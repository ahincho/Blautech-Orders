package com.blautech.ecommerce.orders.application.ports.in;

import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.domain.exceptions.UserNotFoundException;
import com.blautech.ecommerce.orders.domain.models.Order;

public interface CreateOneOrderUseCase {
    Order execute(Order order) throws UserNotFoundException, ProductNotFoundException;
}
