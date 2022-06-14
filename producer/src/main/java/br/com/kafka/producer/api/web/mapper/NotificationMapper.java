package br.com.kafka.producer.api.web.mapper;

import br.com.kafka.producer.api.web.dto.request.NotificationRequestDto;
import br.com.kafka.producer.domain.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

//    @Mapping(source = "client", target = "client")
//    @Mapping(source = "description", target = "description")
//    @Mapping(source = "typeNotification", target = "typeNotification")
    Notification toEntity(NotificationRequestDto request);
}
