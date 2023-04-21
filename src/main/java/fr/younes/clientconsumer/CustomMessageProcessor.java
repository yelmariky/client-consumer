package fr.younes.clientconsumer;

import fr.younes.libkafkaspring.processor.MessageProcessor;


public class CustomMessageProcessor implements MessageProcessor {

    @Override
    public void process(String message) {
        System.out.println("Processing message: " + message);
        // Ajoutez ici votre logique de traitement
    }
}
