package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.mappers;

import com.blautech.ecommerce.orders.domain.models.User;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.UserFeignResponse;

public class UserOpenFeignMapper {
    private UserOpenFeignMapper() {}
    public static User feignResponseToDomain(UserFeignResponse userFeignResponse) {
        return User.builder()
            .id(userFeignResponse.getId())
            .firstname(userFeignResponse.getFirstname())
            .lastname(userFeignResponse.getLastname())
            .build();
    }
}
