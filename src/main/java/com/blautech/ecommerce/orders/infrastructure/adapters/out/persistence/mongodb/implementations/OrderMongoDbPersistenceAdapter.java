package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.implementations;

import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents.OrderDocument;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.mappers.OrderMongoDbMapper;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.repositories.OrderMongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderMongoDbPersistenceAdapter implements OrderPersistencePort {
    private final OrderMongoRepository orderMongoRepository;
    public OrderMongoDbPersistenceAdapter(OrderMongoRepository orderMongoRepository) {
        this.orderMongoRepository = orderMongoRepository;
    }
    @Override
    public Order createOneOrder(Order order) {
        OrderDocument orderDocument = OrderMongoDbMapper.domainToDocument(order);
        OrderDocument savedOrderDocument = orderMongoRepository.save(orderDocument);
        return OrderMongoDbMapper.documentToDomain(savedOrderDocument);
    }
    @Override
    public PaginationResult<Order> findOrders(OrderFilters orderFilters) {
        return null;
    }
    @Override
    public Order findOneOrderById(String id) {
        return null;
    }
}
