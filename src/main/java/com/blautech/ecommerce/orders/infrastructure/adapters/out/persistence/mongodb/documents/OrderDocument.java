package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "orders")
public class OrderDocument {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private Long userId;
    private Set<DetailDocument> details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
