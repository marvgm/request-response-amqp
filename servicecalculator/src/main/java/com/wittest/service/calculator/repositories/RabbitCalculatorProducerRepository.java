package com.wittest.service.calculator.repositories;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RabbitCalculatorProducerRepository {
    void send(BigDecimal result);
}
