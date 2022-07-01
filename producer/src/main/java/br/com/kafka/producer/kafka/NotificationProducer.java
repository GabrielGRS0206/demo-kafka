package br.com.kafka.producer.kafka;

import br.com.kafka.producer.domain.exception.NotificationException;
import br.com.kafka.request.Notification;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NotificationProducer {

    public static final String MESSAGE = "1";
    public static final String EMAIL = "2";

    @Value("topic-notification-email")
    private String topicEmail;

    @Value("topic-notification-message")
    private String topicMessage;

    @Autowired
    private KafkaProperties properties;

    @Autowired
    private KafkaTemplate<String, Notification> producer;

    public void notification(Notification notification) throws NotificationException {
        ProducerRecord<String, Notification> producerRecord = null;

        System.out.println(properties);
       //System.out.println("JSON -->>> "+toJson(notification));
        try {
            //System.out.println(toJson(notification));
            switch (notification.getType()){
                case MESSAGE:
                    producerRecord = new ProducerRecord<>(topicMessage, UUID.randomUUID().toString(), notification);
                    break;
                case EMAIL:
                    producerRecord = new ProducerRecord<>(topicEmail, UUID.randomUUID().toString(), notification);
                    break;
            }
            //System.out.println(toJson(notification));
            this.producer.send(producerRecord);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String toJson(Notification notification) {
        return new Gson().toJson(notification);
    }


}
