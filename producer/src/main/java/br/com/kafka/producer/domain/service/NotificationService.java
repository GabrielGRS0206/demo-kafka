package br.com.kafka.producer.domain.service;

import br.com.kafka.producer.domain.exception.NotificationException;
import br.com.kafka.producer.domain.model.Notification;

@FunctionalInterface
public interface NotificationService {
    void notification(Notification notification) throws NotificationException;
}
