package com.pe.ordermanagement.infrastructure.persistence.repository;

import com.pe.ordermanagement.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveOrderRepository extends ReactiveCrudRepository<OrderEntity, String> {
}
