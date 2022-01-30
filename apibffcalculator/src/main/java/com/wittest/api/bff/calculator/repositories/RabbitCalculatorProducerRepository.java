package com.wittest.api.bff.calculator.repositories;

import com.wittest.api.bff.calculator.entities.ResultDto;

import java.math.BigDecimal;
import java.util.UUID;

public interface RabbitCalculatorProducerRepository {

    ResultDto send(BigDecimal a, BigDecimal b, String operational, UUID id);
}
