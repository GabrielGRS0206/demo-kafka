package br.com.kafka.producer.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotificationException(String message) {
        super(message);
    }

    public NotificationException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public NotificationException(String msg, Long id) {
        this(String.format(msg, id));
    }

}