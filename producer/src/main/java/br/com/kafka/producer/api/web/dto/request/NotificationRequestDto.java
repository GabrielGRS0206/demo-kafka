package br.com.kafka.producer.api.web.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class NotificationRequestDto {

    private Long client;
    private String description;
    private String type;
    private LocalDate date;
    private String system;
}
