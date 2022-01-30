package com.wittest.service.calculator.interactors;

import com.wittest.service.calculator.entities.calculator.ProducerDto;
import com.wittest.service.calculator.entities.calculator.ResultDto;
import com.wittest.service.calculator.entities.enumerators.OperationalEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CalculatorUseCase {

    public ResultDto calcular(ProducerDto producer) {

        OperationalEnum operation = OperationalEnum.desdeValor(producer.getOpec());

        if(operation == null) {
            throw new RuntimeException("Operation impossible to process: " + producer.getOpec());
        }

        ResultDto resultDto = new ResultDto();
        resultDto.setId(producer.getId());

        switch (operation) {
            case SUM:
                resultDto.setResult(BigDecimal.valueOf(producer.getA().add(producer.getB()).doubleValue()));
                return resultDto;
            case MINUS:
                resultDto.setResult(BigDecimal.valueOf(producer.getA().subtract(producer.getB()).doubleValue()));
                return resultDto;
            case MULTIPLICATION:
                resultDto.setResult(BigDecimal.valueOf(producer.getA().multiply(producer.getB()).doubleValue()));
                return resultDto;
            case DIVISION:
                resultDto.setResult(BigDecimal.valueOf(producer.getA().divide(producer.getB(), 2, RoundingMode.HALF_UP).doubleValue()));
                return resultDto;
            default:
                throw new RuntimeException("Unsupported operation to be calculated: " + operation.toString());

        }
    }
}
