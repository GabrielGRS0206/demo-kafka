package br.com.kafka.consumer.domain.service;

import br.com.kafka.consumer.domain.model.Notification;
import br.com.kafka.consumer.domain.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public void save(Notification notification){
        repository.save(notification);
    }
}
