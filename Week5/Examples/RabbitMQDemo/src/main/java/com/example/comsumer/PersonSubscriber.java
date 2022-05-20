package com.example.comsumer;

import com.example.config.MessagingConfig;
import com.example.model.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

@Component
public class PersonSubscriber {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Person p){
        System.out.println("New person from queue: " + p);
    }

}
