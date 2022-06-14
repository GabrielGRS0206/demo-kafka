package br.com.kafka.consumer.kafka.listener;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ConsumerListenerNotificationEmail {

    @KafkaListener(topics = "topic-notification-email")
    public void listenEmail(String notification) {
        log.info(" Listener email -->> "+notification);
    }
}
