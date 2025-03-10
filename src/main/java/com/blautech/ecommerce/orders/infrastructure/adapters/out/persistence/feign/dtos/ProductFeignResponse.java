package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeignResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
