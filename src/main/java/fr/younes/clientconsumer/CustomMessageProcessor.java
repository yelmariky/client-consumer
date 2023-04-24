package fr.younes.clientconsumer;

import org.springframework.stereotype.Service;

import fr.younes.libkafkaspring.processor.MessageProcessor;
@Service
public class CustomMessageProcessor implements MessageProcessor {

    @Override
    public void process(String message) {
        System.out.println("Processing message: " + message);
        // Ajoutez ici votre logique de traitement
    }
}
