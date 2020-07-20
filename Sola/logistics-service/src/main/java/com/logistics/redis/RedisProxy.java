package com.logistics.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class RedisProxy {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisProxy(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 30L, TimeUnit.MINUTES);
    }

    public boolean hasKey(String key){
        Long size = redisTemplate.opsForValue().size(key);
        return size != null && size > 0;
    }


}
