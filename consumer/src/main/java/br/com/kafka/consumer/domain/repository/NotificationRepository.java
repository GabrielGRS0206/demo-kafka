package br.com.kafka.consumer.domain.repository;

import br.com.kafka.consumer.domain.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String>{
}
