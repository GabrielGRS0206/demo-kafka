package br.com.kafka.producer.domain.service.impl;

import br.com.kafka.producer.domain.exception.NotificationException;
import br.com.kafka.producer.domain.helper.util.Utils;
import br.com.kafka.producer.domain.model.Notification;
import br.com.kafka.producer.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationEmailServiceImpl implements NotificationService {

    @Value("topic-notification-email")
    private String topicEmail;

    @Value("topic-notification-message")
    private String topicMessage;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void notification(Notification notification) throws NotificationException {
        try {
            switch (notification.getTypeNotification().getValue()){
                case "MESSAGE":
                    kafkaTemplate.send(topicMessage, UUID.randomUUID().toString(), Utils.objectToJson(notification));
                    break;
                case "EMAIL":
                    kafkaTemplate.send(topicEmail, UUID.randomUUID().toString(), Utils.objectToJson(notification));
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
