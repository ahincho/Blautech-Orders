package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.clients;

import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.UserFeignResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-microservice", url = "http://localhost:8090/api/v1/users")
public interface UserOpenFeignClient {
    @GetMapping("/{userId}")
    UserFeignResponse findOneUserById(@PathVariable Long userId);
}
