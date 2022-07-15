package ru.diasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;
import ru.diasoft.kafka.ProducerChannels;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(ProducerChannels.class)
@IntegrationComponentScan
public class ProviderApp {

    public static void main(String[] args) {

        SpringApplication.run(ProviderApp.class, args);
    }
    
}
