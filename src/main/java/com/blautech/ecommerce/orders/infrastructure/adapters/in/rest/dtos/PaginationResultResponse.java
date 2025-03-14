package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResultResponse<T> {
    private Long totalItems;
    private Long totalPages;
    private Integer currentPage;
    private Integer pageSize;
    private Boolean hastNextPage;
    private List<T> items;
}
