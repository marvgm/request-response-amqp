/*
package com.wittest.service.calculator.datasources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wittest.service.calculator.entities.calculator.ProducerDto;
import com.wittest.service.calculator.entities.calculator.ResultDto;
import com.wittest.service.calculator.repositories.RabbitCalculatorProducerRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RabbitCalculatorProducer implements RabbitCalculatorProducerRepository {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Queue queue;

    @Override
    public ResultDto send(BigDecimal result) {

        ProducerDto producerDto = new ProducerDto();
        producerDto.setResult(result);

        try {
            String mensagemJson = this.objectMapper.writeValueAsString(producerDto);
            this.rabbitTemplate.convertAndSend(queue.getName(), mensagemJson);
            System.out.println(" [x] Sent service to result "+ queue.getName()+" '" + mensagemJson + "'");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
*/
