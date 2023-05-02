package fr.younes.clientconsumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.younes.clientconsumer.model.SuperHero;
import fr.younes.libkafkaspring.processor.MessageProcessor;
@Service
public class CustomMessageProcessor implements MessageProcessor {
    private static final Logger log = LoggerFactory.getLogger(CustomMessageProcessor.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void process(String message) {
        log.info("Processing message: " + message);
        // Ajoutez ici votre logique de traitement
        String url = "http://localhost:8000/super-hero";

ResponseEntity<List<SuperHero>> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<SuperHero>>() {});

        List<SuperHero> superHeroes = response.getBody();

    }
}
