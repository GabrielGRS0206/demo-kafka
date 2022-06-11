package br.com.kafka.producer.api.web.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {

    private Long client;
    private String description;
}
