package com.presentie.administratie.registrationservice.receivers;

import com.presentie.administratie.registrationservice.controllers.StatusController;
import com.presentie.administratie.registrationservice.models.Status;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RabbitListener(queues = "status")
public class StatusReceiver {

    @Autowired
    StatusController controller;

    @RabbitHandler
    public void receive(Status receivedStatus){
        System.out.printf(String.valueOf(receivedStatus));

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate build = builder.build();

        Status status = new Status("Rico", true);
        build.postForObject("/api/status/add", receivedStatus, Status.class);
    }
}
