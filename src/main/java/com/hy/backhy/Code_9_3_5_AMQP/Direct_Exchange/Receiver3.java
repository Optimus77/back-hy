package com.hy.backhy.Code_9_3_5_AMQP.Direct_Exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "DirectQueue3")//监听的队列名称 TestDirectQueue
public class Receiver3 {

    @RabbitHandler
    public void whatEver(String testMessage) {
        System.out.println("Receiver3收到消息  : " + testMessage);
    }

}

