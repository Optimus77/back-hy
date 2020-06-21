package com.hy.backhy.Code_9_3_5_AMQP.Direct_Exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    //队列 起名：DirectQueue1、2、3
    @Bean
    public Queue TestDirectQueue1() {
        return new Queue("DirectQueue1",true);  //true 是否持久
    }
    @Bean
    public Queue TestDirectQueue2() {
        return new Queue("DirectQueue2",true);  //true 是否持久
    }
    @Bean
    public Queue TestDirectQueue3() {
        return new Queue("DirectQueue3",true);  //true 是否持久
    }


    //Direct交换机 起名：DirectExchange1、2
    @Bean
    DirectExchange TestDirectExchange1() {
        return new DirectExchange("DirectExchange1");
    }
    @Bean
    DirectExchange TestDirectExchange2() {
        return new DirectExchange("DirectExchange2");
    }


    //绑定  将队列和交换机绑定, 并设置用于匹配键：DirectBindingKey1、2、3，Queue1-Exchange1，Queue2-Exchange1，Queue3-Exchange2
    @Bean
    Binding bindingDirect1() {
        return BindingBuilder.bind(TestDirectQueue1()).to(TestDirectExchange1()).with("DirectBindingKey1");
    }
    @Bean
    Binding bindingDirect2() {
        return BindingBuilder.bind(TestDirectQueue2()).to(TestDirectExchange1()).with("DirectBindingKey2");
    }
    @Bean
    Binding bindingDirect3() {
        return BindingBuilder.bind(TestDirectQueue3()).to(TestDirectExchange2()).with("DirectBindingKey3");
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

}

