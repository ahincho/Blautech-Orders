package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.feign.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFeignResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private LocalDate birthday;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
