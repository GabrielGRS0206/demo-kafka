package br.com.kafka.producer.api.web.controller;

import br.com.kafka.producer.api.web.dto.request.Notification;
import br.com.kafka.producer.api.web.kafka.KafkaProducerNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    @Autowired
    private KafkaProducerNotification producer;

    @PostMapping
    public void notifications(@RequestBody Notification notification){
        try {
            producer.send(notification);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
