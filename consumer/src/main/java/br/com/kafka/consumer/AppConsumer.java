package br.com.kafka.consumer;

import br.com.kafka.consumer.domain.model.Notification;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@SpringBootApplication
public class AppConsumer {

	public static void main(String[] args) {

		SpringApplication.run(AppConsumer.class, args);
	}

}
