package com.presentie.administratie.registrationservice;

import com.presentie.administratie.registrationservice.receivers.StatusReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class RegistrationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationserviceApplication.class, args);
	}

	@Bean
	public Queue status(){
		return new Queue("status");
	}

	@Bean
    public StatusReceiver receiver(){
	    return new StatusReceiver();
    }

    @Bean
	public CommandLineRunner runner(){
    	return new RabbitAmqpRunner();
	}
}
