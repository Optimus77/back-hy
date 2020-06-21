package com.hy.backhy.Code_9_3_5_AMQP.Direct_Exchange;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "DirectQueue1")//监听的队列名称 TestDirectQueue
public class Receiver1 {

    @RabbitHandler
    public void whatEver(Message testMessage, Channel channel) throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long deliveryTag = testMessage.getMessageProperties().getDeliveryTag();
        //手工ack
        channel.basicAck(deliveryTag,false);
        System.out.println("receive--1: " + new String(testMessage.getBody()));
    }


    @RabbitHandler
    public void whatEver2(String hy, Channel channel, @Headers Map<String,Object> headers) throws IOException {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ack
        channel.basicAck(deliveryTag,true);
        System.out.println("receive--11: " + hy);
    }





}

