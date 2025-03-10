package com.blautech.ecommerce.orders.application.ports.out;

import com.blautech.ecommerce.orders.domain.models.User;

import java.util.Optional;

public interface UserPersistencePort {
    Optional<User> findOneUserById(Long id);
}
