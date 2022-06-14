package br.com.kafka.producer.domain.model;

import br.com.kafka.producer.domain.helper.util.TypeNotification;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {

    private Long client;
    private String description;
    private TypeNotification typeNotification;
}
