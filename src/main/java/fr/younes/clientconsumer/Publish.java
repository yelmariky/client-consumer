package fr.younes.clientconsumer;

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

import fr.younes.libkafkaspring.component.MyKafkaProducer;

@RestController
@RequestMapping("/publish")
public class Publish {

    Logger logger = LoggerFactory.getLogger(Publish.class);

    @Autowired
    MyKafkaProducer producer;

    @Value("${my.kafka.producer.topic}")
    String topic;

    @PostMapping("/messages")
    public ResponseEntity<String> publish(@RequestBody String sendId){
             producer.sendMessage(topic, sendId);
            logger.info("send message OK: {} from topic {}",sendId,topic);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}