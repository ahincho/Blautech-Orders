package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String id;
    private UserResponse user;
    private Set<DetailResponse> details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
