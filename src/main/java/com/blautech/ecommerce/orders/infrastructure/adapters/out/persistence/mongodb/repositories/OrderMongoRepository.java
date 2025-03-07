package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.repositories;

import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents.OrderDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMongoRepository extends MongoRepository<OrderDocument, String> {

}
