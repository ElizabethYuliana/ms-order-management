package com.pe.ordermanagement.infrastructure.controller;

import com.pe.ordermanagement.application.usecase.CreateOrderUseCase;
import com.pe.ordermanagement.domain.model.Order;
import com.pe.ordermanagement.infrastructure.controller.api.OrdersApi;
import com.pe.ordermanagement.infrastructure.dto.CreateOrderRequest;
import com.pe.ordermanagement.infrastructure.dto.OrderResponse;
import com.pe.ordermanagement.infrastructure.dto.PaginatedOrdersResponse;
import com.pe.ordermanagement.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrdersApi {
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderMapper orderMapper;

    @Override
    public Mono<ResponseEntity<Void>> cancelOrder(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<OrderResponse>> createOrder(Mono<CreateOrderRequest> createOrderRequest, ServerWebExchange exchange) {
        return createOrderRequest
                .map(orderMapper::fromRequestToDomain)
                .flatMap(createOrderUseCase::execute)
                .map(co -> ResponseEntity.ok(orderMapper.toResponse(co)));
    }

    @Override
    public Mono<ResponseEntity<OrderResponse>> getOrderById(String id, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Flux<PaginatedOrdersResponse>>> listOrders(Integer page, Integer size, String status, LocalDate fromDate, LocalDate toDate, ServerWebExchange exchange) {
        return null;
    }
}
