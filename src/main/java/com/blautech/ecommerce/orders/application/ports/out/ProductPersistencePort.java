package com.blautech.ecommerce.orders.application.ports.out;

import com.blautech.ecommerce.orders.domain.models.Product;

import java.util.List;

public interface ProductPersistencePort {
    List<Product> findProductsByIds(List<Integer> ids);
}
