package br.com.kafka.producer.api.web.dto.request;

import br.com.kafka.producer.domain.helper.util.TypeNotification;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequestDto {

    private Long client;
    private String description;
    private TypeNotification typeNotification;
}
