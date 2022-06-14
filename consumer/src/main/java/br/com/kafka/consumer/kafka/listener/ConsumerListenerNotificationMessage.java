package br.com.kafka.consumer.kafka.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ConsumerListenerNotificationMessage {

    @KafkaListener(topics = "topic-notification-message")
    public void listenMessage(String notification) {
        log.info(" Listener message -->> "+notification);
    }
}
