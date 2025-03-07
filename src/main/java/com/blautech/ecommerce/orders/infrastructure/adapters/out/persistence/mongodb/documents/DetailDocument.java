package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetailDocument {
    @EqualsAndHashCode.Include
    private Long productId;
    private Integer quantity;
}
