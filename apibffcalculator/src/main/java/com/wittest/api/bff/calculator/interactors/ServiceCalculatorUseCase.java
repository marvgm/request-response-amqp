package com.wittest.api.bff.calculator.interactors;

import com.wittest.api.bff.calculator.datasource.rabbit.RabbitCalculatorProducer;
import com.wittest.api.bff.calculator.entities.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ServiceCalculatorUseCase {

    @Autowired
    private RabbitCalculatorProducer rabbitCalculatorProducer;

    public ResultDto calculate(BigDecimal primerNumero, BigDecimal segundoNumero, String operactional, UUID id) {
        return rabbitCalculatorProducer.send(primerNumero, segundoNumero, operactional, id);
    }
}
