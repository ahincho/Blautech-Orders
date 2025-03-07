package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.implementations;

import com.blautech.ecommerce.orders.application.ports.out.UserPersistencePort;
import com.blautech.ecommerce.orders.domain.models.User;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.clients.UserOpenFeignClient;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.UserFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.mappers.UserOpenFeignMapper;

import feign.FeignException;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserOpenFeignPersistenceAdapter implements UserPersistencePort {
    private final UserOpenFeignClient userOpenFeignClient;
    public UserOpenFeignPersistenceAdapter(UserOpenFeignClient userOpenFeignClient) {
        this.userOpenFeignClient = userOpenFeignClient;
    }
    @Override
    public Optional<User> findOneUserById(Long id) {
        try {
            UserFeignResponse userFeignResponse = this.userOpenFeignClient.findOneUserById(id);
            return Optional.of(UserOpenFeignMapper.feignResponseToDomain(userFeignResponse));
        } catch (FeignException.NotFound feignNotFoundException) {
            return Optional.empty();
        }
    }
}
