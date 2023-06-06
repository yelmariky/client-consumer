package fr.younes.clientconsumer;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import fr.younes.clientconsumer.model.SuperHero;
import fr.younes.libkafkaspring.processor.MessageProcessor;

@Service
public class CustomMessageProcessor implements MessageProcessor<String> {
    private static final Logger log = LoggerFactory.getLogger(CustomMessageProcessor.class);

    @Autowired
    RestTemplate restTemplate;

   // @Value("${url-demo}")
    String urlDemo;

    @Override
    public void process(String message) {
        log.info("Processing user: nom -> {}" ,message.substring(20));
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map < String, Object > map = springParser.parseMap(message.substring(15));
      String mapArray[] = new String[map.size()];
      System.out.println("Items found: " + mapArray.length);
      int i = 0;
      for (Map.Entry < String, Object > entry: map.entrySet()) {
        System.out.println(entry.getKey() + " = " + entry.getValue());
        i++;
      }
    }

        
        
        //GET URL_DEMO
/** 
ResponseEntity<List<SuperHero>> response = restTemplate.exchange(
        urlDemo,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<SuperHero>>() {});

        List<SuperHero> superHeroes = response.getBody();
**/
  //  }

    
}
