package br.com.kafka.consumer.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Notification {

    private Long client;
    private String description;
    private String type;
}
