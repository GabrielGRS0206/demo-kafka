package br.com.kafka.producer.api.web.kafka;

import br.com.kafka.producer.api.web.dto.request.Notification;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.Future;

@Component
public class KafkaProducerNotification {

    @Value("topic-notification")
    private String topicName;

    public KafkaProducerNotification(Properties configProperties) {
        super();
    }

    public String send(Notification notification) throws Exception {

        Gson gson = new Gson();
        String jsonString = gson.toJson(notification);
        System.out.println(" Json -->> "+ jsonString);


        // Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        Producer<String, String> producer = (Producer<String, String>) new KafkaProducer(configProperties);

        ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, jsonString);
        Future<RecordMetadata> results = producer.send(rec);
        RecordMetadata metadata = results.get();

        System.out.println("GEROU MENSAGENS NO TOPICO");

        return topicName;
    }
}
