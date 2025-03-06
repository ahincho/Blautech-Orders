package com.blautech.ecommerce.orders.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private User user;
    private List<Detail> details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
