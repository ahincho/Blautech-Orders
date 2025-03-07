package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckOpenFeignResponse {
    private Boolean success;
}
