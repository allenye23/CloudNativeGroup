package com.horror.client.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication
public class CacheApplication {

    private static Logger log = LoggerFactory.getLogger(CacheApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RedisCacheService cacheService) throws Exception {
        return args -> {
            String firstString = cacheService.cacheThis();
            log.info("First: {}", firstString);
            String secondString = cacheService.cacheThis();
            log.info("Second: {}", secondString);
        };
    }

}
