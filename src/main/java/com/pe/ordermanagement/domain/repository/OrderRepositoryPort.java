package com.pe.ordermanagement.domain.repository;

import com.pe.ordermanagement.domain.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepositoryPort {
    Mono<Order> save(Order order);
    Mono<Order> findById(String id);
    Flux<Order> findAll();
    Mono<Void> deleteById(String id);
}
