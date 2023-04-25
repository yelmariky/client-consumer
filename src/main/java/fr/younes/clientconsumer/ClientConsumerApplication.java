package fr.younes.clientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import fr.younes.libkafkaspring.config.KafkaConfig;


@SpringBootApplication
@Import({KafkaConfig.class})
public class ClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientConsumerApplication.class, args);
    }
}



