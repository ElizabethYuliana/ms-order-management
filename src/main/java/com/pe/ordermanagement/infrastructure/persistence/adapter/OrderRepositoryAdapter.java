package com.pe.ordermanagement.infrastructure.persistence.adapter;

import com.pe.ordermanagement.domain.model.Order;
import com.pe.ordermanagement.domain.repository.OrderRepositoryPort;
import com.pe.ordermanagement.infrastructure.mapper.OrderMapper;
import com.pe.ordermanagement.infrastructure.persistence.repository.ReactiveOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    private final ReactiveOrderRepository reactiveOrderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Mono<Order> save(Order order) {
        return reactiveOrderRepository.save(orderMapper.fromOrdertoOrderEntity(order))
                .map(orderMapper::fromOrderEntitytoOrder);
    }

    @Override
    public Mono<Order> findById(String id) {
        return null;
    }

    @Override
    public Flux<Order> findAll() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }
}
