package br.com.kafka.producer.api.web.controller;

import br.com.kafka.producer.api.web.dto.request.NotificationRequestDto;
import br.com.kafka.producer.domain.model.Notification;
import br.com.kafka.producer.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    @Autowired
    private NotificationService service;

    //NotificationMapper mapper = Mappers.getMapper( NotificationMapper.class );

    @PostMapping
    public ResponseEntity<String> notification(@RequestBody NotificationRequestDto notification){
        service.notification(Notification.builder()
                .client(notification.getClient())
                .description(notification.getDescription())
                .typeNotification(notification.getTypeNotification()).build());
        return null;
    }
}
