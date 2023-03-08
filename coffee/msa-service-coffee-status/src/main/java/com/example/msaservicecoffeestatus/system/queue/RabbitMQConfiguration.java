package com.example.msaservicecoffeestatus.system.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMQConfiguration {

    public static final String RECEIVER_MESSAGE = "ORDER_COFFEE_MESSAGE";

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    public Queue queue() {
        return new Queue(RECEIVER_MESSAGE);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(20);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setErrorHandler(new ConditionalRejectingErrorHandler());
        return factory;
    }
}
