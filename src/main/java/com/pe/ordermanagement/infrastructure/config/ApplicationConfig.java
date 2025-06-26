package com.pe.ordermanagement.infrastructure.config;

import com.pe.ordermanagement.application.usecase.CreateOrderUseCase;
import com.pe.ordermanagement.domain.repository.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepositoryPort repository) {
        return new CreateOrderUseCase(repository);
    }
}
