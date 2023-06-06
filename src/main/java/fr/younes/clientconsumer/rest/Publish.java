package fr.younes.clientconsumer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.younes.clientconsumer.model.User;
import fr.younes.libkafkaspring.component.MyKafkaProducer;
import fr.younes.clientconsumer.avro.Person;

@RestController
@RequestMapping("/publish")
public class Publish {

    Logger logger = LoggerFactory.getLogger(Publish.class);

    @Autowired
    MyKafkaProducer<Person> producer;

    @Value("${my.kafka.producer.topic}")
    String topic;

    @PostMapping("/messages")
    public ResponseEntity<String> publish(@RequestBody User sendId){
        Person p = new Person();
        p.setNom(sendId.getNom());
        p.setPrenom(sendId.getPrenom());
        p.setAge(sendId.getAge());
             producer.sendMessage(topic, p);
            logger.info("send message OK: {} from topic {}",sendId,topic);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}