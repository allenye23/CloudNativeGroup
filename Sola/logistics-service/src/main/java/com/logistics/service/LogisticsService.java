package com.logistics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.redis.RedisProxy;
import com.logistics.repository.LogisticsRepository;
import common.entities.Logistics;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LogisticsService {

    private final RedisProxy redisProxy;

    private final LogisticsRepository logisticsRepository;

    public LogisticsService(RedisProxy redisProxy, LogisticsRepository logisticsRepository) {
        this.redisProxy = redisProxy;
        this.logisticsRepository = logisticsRepository;
    }

    @Transactional
    public Logistics findLogistics(String orderNumber) throws JsonProcessingException {
        Logistics logisticsCache = getLogisticsFromCache(orderNumber);
        if (logisticsCache != null) {
            return logisticsCache;
        }
        return getLogisticsFromDB(orderNumber);
    }

    private Logistics getLogisticsFromCache(String orderNumber) throws JsonProcessingException {
        Optional<String> logisticsStr = redisProxy.get(orderNumber);
        if(logisticsStr.isPresent()){
            return new ObjectMapper().readValue(logisticsStr.get(), Logistics.class);
        }
        return null;
    }

    private Logistics getLogisticsFromDB(String orderNumber) throws JsonProcessingException {
        Optional<Logistics> logistics = logisticsRepository.findByOrderNumber(orderNumber);
        if(logistics.isPresent()){
            redisProxy.set(orderNumber, new ObjectMapper().writeValueAsString(logistics));
            return logistics.get();
        }
        return null;
    }

}
