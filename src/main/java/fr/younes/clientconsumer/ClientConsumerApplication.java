package fr.younes.clientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import fr.younes.libkafkaspring.config.KafkaConfig;

import  fr.younes.libkafkaspring.config.EnableMyKafkaConsumer;


@SpringBootApplication
@Import({KafkaConfig.class})
@EnableMyKafkaConsumer
public class ClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientConsumerApplication.class, args);
    }
}



