package ru.diasoft;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import ru.diasoft.kafka.ConsumerChannels;


@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class ConsumerApp {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApp.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("myTopic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id="1", topics = "myTopic")
    public void listen(String msg) {
        System.out.println("Get message: " + msg);
    }
}
