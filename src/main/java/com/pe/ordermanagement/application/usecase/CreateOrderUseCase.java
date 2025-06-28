package com.pe.ordermanagement.application.usecase;

import com.pe.ordermanagement.domain.model.Order;
import com.pe.ordermanagement.domain.model.OrderStatus;
import com.pe.ordermanagement.domain.repository.OrderRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final OrderRepositoryPort orderRepository;

    public Mono<Order> execute(Order order) {
        Order orderToSave = Order.builder()
                .customerId(order.getCustomerId())
                .amount(order.getAmount())
                .description(order.getDescription())
                .status(OrderStatus.CREATED)
                .build();
        return orderRepository.save(orderToSave);
    }
}
