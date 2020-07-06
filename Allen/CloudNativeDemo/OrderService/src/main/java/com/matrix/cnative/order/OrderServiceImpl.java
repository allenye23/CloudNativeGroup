package com.matrix.cnative.order;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MessageSender messageSender;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @Override
    public void submitOrder(Order order) {
        orderRepository.save(order);
        messageSender.send(order.getId()+"_"+order.getAddress());

    }

    @Cacheable(value = "orders")
    public  Order findOrder(Integer orderId ){
        return orderRepository.findById(orderId).get();
    }

    @HystrixCommand(fallbackMethod = "defaultLogistics")
    public LogisticDTO getLogisticDTO(String id) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("logistics-service", false);
        String homePageUrl = instance.getHomePageUrl();
        return this.restTemplate.getForObject(homePageUrl +"logistics/{orderId}",LogisticDTO.class,id);
    }

    public LogisticDTO defaultLogistics(String id) {
        LogisticDTO dto = new LogisticDTO();
        dto.setAddress("fallback");
        dto.setProcess("fallback");
        return dto;
    }


}
