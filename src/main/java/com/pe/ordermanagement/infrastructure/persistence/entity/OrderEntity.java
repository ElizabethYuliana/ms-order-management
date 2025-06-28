package com.pe.ordermanagement.infrastructure.persistence.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("ORDERS")
@Data @Builder
public class OrderEntity {

    @Id
    private String id;
    private String customerId;
    private BigDecimal amount;
    private String description;
    private String status;
    private LocalDateTime createAt;
}
