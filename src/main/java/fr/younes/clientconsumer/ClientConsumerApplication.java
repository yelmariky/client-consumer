package fr.younes.clientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  fr.younes.libkafkaspring.config.EnableMyKafkaConsumer;


@SpringBootApplication
@EnableMyKafkaConsumer
public class ClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientConsumerApplication.class, args);
    }
}



