package br.com.kafka.producer.domain.helper.util;

public enum TypeNotification {

    MESSAGE("MESSAGE"),EMAIL("EMAIL");

    private String value;

    TypeNotification(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
