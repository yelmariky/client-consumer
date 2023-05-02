package fr.younes.clientconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.younes.libkafkaspring.processor.MessageProcessor;
@Service
public class CustomMessageProcessor implements MessageProcessor {
    private static final Logger log = LoggerFactory.getLogger(CustomMessageProcessor.class);

    @Override
    public void process(String message) {
        log.info("Processing message: " + message);
        // Ajoutez ici votre logique de traitement
    }
}
