package com.wittest.service.calculator.transportlayers;

import ch.qos.logback.classic.Logger;
import com.wittest.service.calculator.entities.calculator.ProducerDto;
import com.wittest.service.calculator.entities.calculator.ResultDto;
import com.wittest.service.calculator.interactors.CalculatorUseCase;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumerCalculator {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RabbitConsumerCalculator.class);

    @Autowired
    private CalculatorUseCase calculatorUseCase;


    @RabbitListener(queues = "#{queue.name}", concurrency = "10")
    public ResultDto receive(ProducerDto producer) {
        LOGGER.info("id  - {}", producer.getId());

        return calculatorUseCase.calcular(producer);
    }

}
