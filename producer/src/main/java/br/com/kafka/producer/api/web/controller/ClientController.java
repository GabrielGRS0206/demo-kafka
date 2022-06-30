package br.com.kafka.producer.api.web.controller;

import br.com.kafka.producer.api.web.dto.request.NotificationRequestDto;
import br.com.kafka.producer.kafka.NotificationProducer;
import com.irs.register.avro.notification.Notification;
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
    private NotificationProducer service;

    //NotificationMapper mapper = Mappers.getMapper( NotificationMapper.class );

    @PostMapping
    public ResponseEntity notification(@RequestBody NotificationRequestDto request){
        service.notification(
                Notification.newBuilder()
                        .setClient(request.getClient())
                        .setDescription(request.getDescription())
                        .setType(request.getType())
                        .setDate(request.getDate().toString())
                        .setSystem(request.getSystem())
                        .build()

                );
        return ResponseEntity.ok("notification ok");
    }
}
