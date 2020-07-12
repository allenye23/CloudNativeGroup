package com.horror.web;

import java.util.concurrent.atomic.AtomicLong;

import com.horror.rest.ConsumingRestApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/")
    public String all(RestTemplate restTemplate) {
        ResponseEntity<String> entity = restTemplate.getForEntity(
                "http://localhost:8001" + "/greeting", String.class);
        log.info(entity.toString());
        return entity.getBody();
    }
}