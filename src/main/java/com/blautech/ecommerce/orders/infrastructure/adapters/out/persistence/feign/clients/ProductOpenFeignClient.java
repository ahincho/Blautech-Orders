package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.clients;

import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.CheckOpenFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductFeignResponse;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos.ProductIdsRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products-microservice", url = "http://localhost:8080/api/v1/products")
public interface ProductOpenFeignClient {
    @GetMapping("/ids")
    List<ProductFeignResponse> findProductsByIds(@RequestParam List<Long> ids);
    @PostMapping("/ids")
    CheckOpenFeignResponse existsProductsByIds(@RequestBody ProductIdsRequest ids);
}
