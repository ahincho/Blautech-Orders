package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.implementations;

import com.blautech.ecommerce.orders.application.ports.out.OrderPersistencePort;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents.OrderDocument;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.mappers.OrderMongoDbMapper;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.repositories.OrderMongoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class OrderMongoDbPersistenceAdapter implements OrderPersistencePort {
    private final OrderMongoRepository orderMongoRepository;
    public OrderMongoDbPersistenceAdapter(OrderMongoRepository orderMongoRepository) {
        this.orderMongoRepository = orderMongoRepository;
    }
    @Override
    @Transactional
    public Order createOneOrder(Order order) {
        OrderDocument orderDocument = OrderMongoDbMapper.domainToDocument(order);
        OrderDocument savedOrderDocument = this.orderMongoRepository.save(orderDocument);
        return OrderMongoDbMapper.documentToDomain(savedOrderDocument);
    }
    @Override
    public PaginationResult<Order> findOrders(OrderFilters orderFilters) {
        Pageable pageable = OrderMongoDbMapper.domainPageToEntityPage(orderFilters);
        Page<OrderDocument> orderDocuments = this.orderMongoRepository.findAll(pageable);
        return OrderMongoDbMapper.entityPageToDomainPage(orderDocuments);
    }
    @Override
    public Optional<Order> findOneOrderById(String id) {
        Optional<OrderDocument> orderDocument = this.orderMongoRepository.findById(id);
        return orderDocument.map(OrderMongoDbMapper::documentToDomain);
    }
}
