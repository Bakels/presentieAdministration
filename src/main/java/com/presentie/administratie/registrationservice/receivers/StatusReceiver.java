package com.presentie.administratie.registrationservice.receivers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "status")
public class StatusReceiver {

    @RabbitHandler
    public void receive(String in){
        System.out.printf(in);
    }
}
