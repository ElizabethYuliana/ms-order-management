package com.pe.ordermanagement.infrastructure.mapper;

import com.pe.ordermanagement.domain.model.Order;
import com.pe.ordermanagement.domain.model.OrderStatus;
import com.pe.ordermanagement.infrastructure.dto.CreateOrderRequest;
import com.pe.ordermanagement.infrastructure.dto.OrderResponse;
import com.pe.ordermanagement.infrastructure.persistence.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderMapper {

    public OrderEntity fromOrdertoOrderEntity(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .amount(order.getAmount())
                .description(order.getDescription())
                .status(order.getStatus().name())
                .createAt(order.getCreatedAt())
                .build();
    }

    public Order fromOrderEntitytoOrder(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .customerId(orderEntity.getCustomerId())
                .amount(orderEntity.getAmount())
                .description(orderEntity.getDescription())
                .status(OrderStatus.valueOf(orderEntity.getStatus()))
                .createdAt(orderEntity.getCreateAt())
                .build();
    }

    public OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .amount(order.getAmount().doubleValue())
                .description(order.getDescription())
                .status(OrderResponse.StatusEnum.valueOf(order.getStatus().name()))
                .createdAt(order.getCreatedAt())
                .build();
    }

    public Order fromRequestToDomain(CreateOrderRequest createOrderRequest) {
        return Order.builder()
                .id(UUID.randomUUID().toString())
                .customerId(createOrderRequest.getCustomerId())
                .amount(createOrderRequest.getAmount())
                .description(createOrderRequest.getDescription())
                .build();
    }
}
