package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOneOrderRequest {
    @NotNull(message = "User id is required")
    @Positive(message = "User id must be a positive integer")
    private Long userId;
    @Valid
    @NotNull(message = "Details are required")
    @Size(min = 1, message = "At least one detail is required")
    private Set<DetailRequest> details;
}
