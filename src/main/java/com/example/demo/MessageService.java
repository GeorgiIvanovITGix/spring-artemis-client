package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void sendTestMessage() {
        jmsTemplate.convertAndSend("testQueue", "Hello from Spring Boot!");
    }

    @JmsListener(destination = "testQueue")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}
