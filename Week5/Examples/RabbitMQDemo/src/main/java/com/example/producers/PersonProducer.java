package com.example.producers;

import com.example.config.MessagingConfig;
import com.example.model.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class PersonProducer {

    @Autowired
    RabbitTemplate template;

    @PostMapping("/")
    public Person createPerson(@RequestBody Person p){
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTINGKEY, p);
        return p;
    }

}
