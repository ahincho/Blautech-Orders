package com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.mappers;

import com.blautech.ecommerce.orders.domain.models.Detail;
import com.blautech.ecommerce.orders.domain.models.Order;
import com.blautech.ecommerce.orders.domain.models.OrderFilters;
import com.blautech.ecommerce.orders.domain.models.PaginationResult;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents.DetailDocument;
import com.blautech.ecommerce.orders.infrastructure.adapters.out.persistence.mongodb.documents.OrderDocument;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMongoDbMapper {
    private OrderMongoDbMapper() {}
    public static OrderDocument domainToDocument(Order order) {
        return OrderDocument.builder()
            .userId(order.getUserId())
            .details(order.getDetails().stream().map(OrderMongoDbMapper::domainDetailToDetailDocument).collect(Collectors.toSet()))
            .createdAt(order.getCreatedAt() == null ? LocalDateTime.now() : order.getCreatedAt())
            .updatedAt(order.getUpdatedAt() == null ? LocalDateTime.now() : order.getUpdatedAt())
            .build();
    }
    public static Order documentToDomain(OrderDocument orderDocument) {
        return Order.builder()
            .id(orderDocument.getId())
            .userId(orderDocument.getUserId())
            .details(orderDocument.getDetails().stream().map(OrderMongoDbMapper::detailDocumentToDomainDetail).collect(Collectors.toSet()))
            .createdAt(orderDocument.getCreatedAt())
            .updatedAt(orderDocument.getUpdatedAt())
            .build();
    }
    protected static DetailDocument domainDetailToDetailDocument(Detail detail) {
        return DetailDocument.builder()
            .productId(detail.getProductId())
            .quantity(detail.getQuantity())
            .build();
    }
    protected static Detail detailDocumentToDomainDetail(DetailDocument detailDocument) {
        return Detail.builder()
            .productId(detailDocument.getProductId())
            .quantity(detailDocument.getQuantity())
            .build();
    }
    public static Pageable domainPageToEntityPage(OrderFilters orderFilters) {
        return PageRequest.of(
            orderFilters.getPage().getNumber(),
            orderFilters.getPage().getSize(),
            Sort.by(Sort.Direction.ASC, "id")
        );
    }
    public static List<Order> entityListToDomainList(List<OrderDocument> orderDocuments) {
        return orderDocuments.stream()
            .map(OrderMongoDbMapper::documentToDomain)
            .toList();
    }
    public static PaginationResult<Order> entityPageToDomainPage(Page<OrderDocument> orderDocumentPage) {
        return PaginationResult.<Order>builder()
            .totalItems(orderDocumentPage.getTotalElements())
            .totalPages(orderDocumentPage.getTotalPages())
            .currentPage(orderDocumentPage.getNumber())
            .pageSize(orderDocumentPage.getSize())
            .hasNextPage(orderDocumentPage.hasNext())
            .items(entityListToDomainList(orderDocumentPage.getContent()))
            .build();
    }
}
