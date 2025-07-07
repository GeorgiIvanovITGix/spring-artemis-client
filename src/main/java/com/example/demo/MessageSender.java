package com.example.demo;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000) // Изпраща съобщение на всеки 2 секунди
    public void sendMessage() {
        String message = "Test Message: " + LocalDateTime.now();
        jmsTemplate.convertAndSend("test.queue", message);
        System.out.println("Sent: " + message);
    }
}
