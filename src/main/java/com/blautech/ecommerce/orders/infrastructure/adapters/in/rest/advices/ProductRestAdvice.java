package com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.advices;

import com.blautech.ecommerce.orders.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.orders.infrastructure.adapters.in.rest.dtos.ExceptionResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductRestAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponse> productNotFoundException(
        ProductNotFoundException productNotFoundException,
        HttpServletRequest httpServletRequest
    ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .path(httpServletRequest.getRequestURI())
            .method(httpServletRequest.getMethod())
            .statusCode(HttpStatus.NOT_FOUND.value())
            .statusDescription(HttpStatus.NOT_FOUND.name())
            .message(productNotFoundException.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
