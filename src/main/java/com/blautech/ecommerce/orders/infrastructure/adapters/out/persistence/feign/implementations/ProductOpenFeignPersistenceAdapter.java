package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.implementations;

import com.blautech.ecommerce.orders.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.orders.domain.models.Product;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.clients.ProductOpenFeignClient;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.CheckOpenFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductIdsRequest;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.mappers.ProductOpenFeignMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOpenFeignPersistenceAdapter implements ProductPersistencePort {
    private final ProductOpenFeignClient productOpenFeignClient;
    public ProductOpenFeignPersistenceAdapter(ProductOpenFeignClient productOpenFeignClient) {
        this.productOpenFeignClient = productOpenFeignClient;
    }
    @Override
    public List<Product> findProductsByIds(List<Long> ids) {
        List<ProductFeignResponse> productFeignResponses = this.productOpenFeignClient.findProductsByIds(ids);
        return productFeignResponses.stream()
            .map(ProductOpenFeignMapper::feignResponseToDomain)
            .toList();
    }
    @Override
    public boolean existsProductsByIds(List<Long> ids) {
        ProductIdsRequest productIdsRequest = ProductOpenFeignMapper.domainIdsToRequestIds(ids);
        CheckOpenFeignResponse checkOpenFeignResponse = this.productOpenFeignClient.existsProductsByIds(productIdsRequest);
        return checkOpenFeignResponse.getSuccess();
    }
}
