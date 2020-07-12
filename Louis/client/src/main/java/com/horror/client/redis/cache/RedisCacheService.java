package com.horror.client.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    private static Logger log = LoggerFactory.getLogger(CacheApplication.class);

    @Cacheable(cacheNames = "myCache")
    public String cacheThis() {
        log.info("Returning NOT from cache!");
        return "this Is it";
    }
}
