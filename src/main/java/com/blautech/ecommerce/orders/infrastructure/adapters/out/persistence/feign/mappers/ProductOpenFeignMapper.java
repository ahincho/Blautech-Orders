package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.mappers;

import com.blautech.ecommerce.orders.domain.models.Product;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductIdsRequest;

import java.util.List;

public class ProductOpenFeignMapper {
    private ProductOpenFeignMapper() {}
    public static Product feignResponseToDomain(ProductFeignResponse productFeignResponse) {
        return Product.builder()
            .id(productFeignResponse.getId())
            .name(productFeignResponse.getName())
            .description(productFeignResponse.getDescription())
            .price(productFeignResponse.getPrice())
            .build();
    }
    public static ProductIdsRequest domainIdsToRequestIds(List<Long> productIds) {
        return ProductIdsRequest.builder()
            .ids(productIds)
            .build();
    }
}
