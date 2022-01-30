package com.wittest.api.bff.calculator.datasource.rabbit;

import ch.qos.logback.classic.Logger;
import com.wittest.api.bff.calculator.entities.ProducerDto;
import com.wittest.api.bff.calculator.entities.ResultDto;
import com.wittest.api.bff.calculator.repositories.RabbitCalculatorProducerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
public class RabbitCalculatorProducer implements RabbitCalculatorProducerRepository {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RabbitCalculatorProducer.class);

    public static final String ROUTING_KEY = "old.calc";

    @Autowired
    private Queue queue;

    @Autowired
    private AsyncRabbitTemplate asyncRabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Override
    public ResultDto send(BigDecimal a, BigDecimal b, String operational, UUID id) {

        ProducerDto producerDto = new ProducerDto();
        producerDto.setId(id);
        producerDto.setA(a);
        producerDto.setB(b);
        producerDto.setOpec(operational);

        LOGGER.info("id  - {}", id);

        ListenableFuture<ResultDto> listenableFuture =
                asyncRabbitTemplate.convertSendAndReceiveAsType(
                        directExchange.getName(),
                        ROUTING_KEY,
                        producerDto,
                        message -> {
                            message.getMessageProperties().setHeader("id", id.toString());
                            return message;
                        },
                        new ParameterizedTypeReference<>() {
                        });
        try {
            ResultDto resultDto = listenableFuture.get();
            return resultDto;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Server down");
        }

        return null;
    }

    public Message postProcessMessage(Message m, UUID id) throws AmqpException {
        m.getMessageProperties().getHeaders().put("id", id);
        return m;
    }
}
