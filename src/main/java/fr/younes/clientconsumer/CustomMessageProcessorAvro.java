package fr.younes.clientconsumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.younes.clientconsumer.model.SuperHero;
import fr.younes.libkafkaspring.processor.MessageProcessor;
import fr.younes.clientconsumer.avro.Person;
//@Service
//public class CustomMessageProcessorAvro implements MessageProcessor<Person> {
  public class CustomMessageProcessorAvro {

  
    private static final Logger log = LoggerFactory.getLogger(CustomMessageProcessor.class);

  //  @Autowired
    RestTemplate restTemplate;

   // @Value("${url-demo}")
    String urlDemo;

    //@Override
    public void process(Person message) {
        log.info("Processing user: nom -> {}, prenom -> {}, age -> {}" ,message.getNom(),message.getPrenom(),message.getAge());
        
        //GET URL_DEMO
/** 
ResponseEntity<List<SuperHero>> response = restTemplate.exchange(
        urlDemo,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<SuperHero>>() {});

        List<SuperHero> superHeroes = response.getBody();
**/
    }

    
}
