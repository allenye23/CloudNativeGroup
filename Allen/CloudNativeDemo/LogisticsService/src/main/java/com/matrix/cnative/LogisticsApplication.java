package com.matrix.cnative;

import com.matrix.cnative.logistics.LogisticDTO;
import com.matrix.cnative.logistics.Logistics;
import com.matrix.cnative.logistics.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class LogisticsApplication {

    @Autowired
    LogisticsRepository repository;

    @RequestMapping(value = "/logistics/{orderId}",method = RequestMethod.GET)
    public LogisticDTO submitOrder(@PathVariable("orderId") Integer orderId){


        Optional<Logistics> logistics = repository.findByOrderId(orderId);
        LogisticDTO logisticDTO  = new LogisticDTO();
        logistics.ifPresent(new Consumer<Logistics>() {
            @Override
            public void accept(Logistics logistics) {
                logisticDTO.setAddress(logistics.getAddress());
                logisticDTO.setProcess(logistics.getArrivalTime().toString());
            }
        });
        return logisticDTO;
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(LogisticsApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
