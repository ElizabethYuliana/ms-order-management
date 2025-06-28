package com.pe.ordermanagement.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @Builder
public class Order {
    private String id;
    private String customerId;
    private BigDecimal amount;
    private String description;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public void cancel() {

        if (this.status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order is already cancelled");
        }
        this.status = OrderStatus.CANCELLED;
    }

    /*public Order(String customerId, BigDecimal amount, String description) {
        this.customerId = customerId;
        this.amount = amount;
        this.description = description;
    }*/
}
